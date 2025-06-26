package dev.codemorph.benchmark

import com.github.difflib.DiffUtils
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.fail
import java.io.File

object TestRunner {

    fun runCase(casePath: String): Collection<DynamicTest> {
        val caseDir = File(casePath)
        require(caseDir.exists() && caseDir.isDirectory) { "Missing test folder: $casePath" }

        val displayNamePrefix = extractDisplayName(caseDir) ?: caseDir.name

        val files = caseDir.listFiles { f -> f.isFile }?.toList() ?: emptyList()

        // Temporarily allow nullable pair values
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

            DynamicTest.dynamicTest(testDisplayName) {
                if (!actualFile.exists()) {
                    fail("Missing actual file for: ${expectedFile.name}")
                }

                val expected = expectedFile.readText()
                val actual = actualFile.readText()

                if (expected != actual) {
                    val patch = DiffUtils.diff(expected.lines(), actual.lines())
                    val diffOutput = patch.deltas.joinToString("\n") { delta ->
                        """
                            Actual: ${delta.source.lines}
                            Expect: ${delta.target.lines}
                        """.trimIndent()
                    }
                    fail("Mismatch in test scenario $base\n$diffOutput")
                }
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
