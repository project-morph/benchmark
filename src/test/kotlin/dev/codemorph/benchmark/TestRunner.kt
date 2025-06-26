package dev.codemorph.benchmark

import com.github.difflib.DiffUtils
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.fail
import java.io.File
import java.io.FileFilter

object TestRunner {

    fun runCase(casePath: String): Collection<DynamicTest> {
        val caseDir = File(casePath)
        require(caseDir.exists() && caseDir.isDirectory) { "Missing test folder: $casePath" }

        val displayNamePrefix = extractDisplayName(caseDir) ?: caseDir.name
        val files = caseDir.listFiles { f -> f.isFile }?.toList() ?: emptyList()

        val filePairs = mutableMapOf<String, Pair<File?, File?>>()

        for (file in files) {
            val name = file.name
            when {
                "_expected." in name -> {
                    val base = name.substringBefore("_expected.")
                    val current = filePairs[base]
                    filePairs[base] = Pair(file, current?.second)
                }
                "_actual." in name -> {
                    val base = name.substringBefore("_actual.")
                    val current = filePairs[base]
                    filePairs[base] = Pair(current?.first, file)
                }
                name.matches(Regex(".*Expected\\.[^/\\\\]+$")) -> {
                    val base = name.replaceFirst("Expected", "")
                    val current = filePairs[base]
                    filePairs[base] = Pair(file, current?.second)
                }
                name.matches(Regex(".*Actual\\.[^/\\\\]+$")) -> {
                    val base = name.replaceFirst("Actual", "")
                    val current = filePairs[base]
                    filePairs[base] = Pair(current?.first, file)
                }
            }
        }

        return filePairs.mapNotNull { (base, pair) ->
            val expectedFile = pair.first
            val actualFile = pair.second
            if (expectedFile == null || actualFile == null) return@mapNotNull null

            val suffix = expectedFile.extension
            val testDisplayName = "$displayNamePrefix - $base$suffix"

            compareFiles(testDisplayName, expectedFile, actualFile, skipFirstLine = false)
        }
    }

    fun runCaseJava(expectedDirPath: String, actualDirPath: String): Collection<DynamicTest> {
        val expectedDir = File(expectedDirPath)
        val actualDir = File(actualDirPath)

        require(expectedDir.exists() && expectedDir.isDirectory) { "Missing expected dir: $expectedDirPath" }
        require(actualDir.exists() && actualDir.isDirectory) { "Missing actual dir: $actualDirPath" }

        val expectedFiles =
            expectedDir.listFiles(FileFilter { it.isFile && it.extension == "java" }) ?: return emptyList()
        val actualFilesMap =
            actualDir.listFiles(FileFilter { it.isFile && it.extension == "java" })?.associateBy { it.name }
                ?: emptyMap()

        val displayNamePrefix = "${expectedDir.name} vs ${actualDir.name}"

        return expectedFiles.mapNotNull { expected ->
            val actual = actualFilesMap[expected.name] ?: return@mapNotNull null
            val testDisplayName = "$displayNamePrefix - ${expected.name}"

            compareFiles(testDisplayName, expected, actual, skipFirstLine = true)
        }
    }

    private fun compareFiles(
        displayName: String,
        expectedFile: File,
        actualFile: File,
        skipFirstLine: Boolean
    ): DynamicTest {
        return DynamicTest.dynamicTest(displayName) {
            val expectedLines = expectedFile.readLines()
            val actualLines = actualFile.readLines()

            val expected = if (skipFirstLine) expectedLines.drop(1) else expectedLines
            val actual = if (skipFirstLine) actualLines.drop(1) else actualLines

            if (expected != actual) {
                val patch = DiffUtils.diff(expected, actual)
                val diffOutput = patch.deltas.joinToString("\n") { delta ->
                    """
                        Actual: ${delta.source.lines}
                        Expect: ${delta.target.lines}
                    """.trimIndent()
                }
                fail("Mismatch in test: $displayName\n$diffOutput")
            }
        }
    }

    private fun extractDisplayName(dir: File): String? {
        val desc = File(dir, "story.md")
        if (!desc.exists()) return null
        return desc.readLines().firstOrNull { it.trim().startsWith("#") }
            ?.removePrefix("#")?.trim()
    }
}
