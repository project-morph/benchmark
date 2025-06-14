package dev.codemorph.benchmark

import com.github.difflib.DiffUtils
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.fail
import java.io.File
import java.nio.file.Paths

object TestRunner {

    private val resourcesDir = Paths.get("src/main/resources").toFile()

    fun runCase(caseName: String): Collection<DynamicTest> {
        val caseDir = File(resourcesDir, caseName)
        require(caseDir.exists() && caseDir.isDirectory) { "Missing test folder: $caseName" }

        val displayNamePrefix = extractDisplayName(caseDir) ?: caseName

        val files = caseDir.listFiles { f -> f.isFile }?.toList() ?: emptyList()

        val expectedMap = files
            .filter { it.name.contains("_expected.") }
            .associateBy {
                it.name.substringBefore("_expected.")
            }

        return expectedMap.map { (baseName, expectedFile) ->
            val expectedSuffix = expectedFile.name.substringAfter("_expected.")
            val actualFile = File(caseDir, "${baseName}_actual.$expectedSuffix")

            val testDisplayName = "$displayNamePrefix - $baseName.$expectedSuffix"

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
                    fail("Mismatch in test scenario $baseName\n$diffOutput")
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
