package dev.codemorph.benchmark

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.fail
import java.io.File
import java.nio.file.Paths

object TestRunner {

    private val resourcesDir = Paths.get("src/main/resources").toFile()

    fun runCase(caseName: String): DynamicTest {
        val caseDir = File(resourcesDir, caseName)
        require(caseDir.exists() && caseDir.isDirectory) { "Missing test folder: $caseName" }

        val displayName = extractDisplayName(caseDir) ?: caseName

        return DynamicTest.dynamicTest(displayName) {
            val failures = mutableListOf<String>()

            val files = caseDir.listFiles { f -> f.isFile }?.toList() ?: emptyList()

            val expectedMap = files
                .filter { it.name.contains("_expected.") }
                .associateBy {
                    it.name.substringBefore("_expected.")
                }

            for ((baseName, expectedFile) in expectedMap) {
                val expectedSuffix = expectedFile.name.substringAfter("_expected.")
                val actualFile = File(caseDir, "${baseName}_actual.$expectedSuffix")

                if (!actualFile.exists()) {
                    failures.add("Missing actual file for: ${expectedFile.name}")
                    continue
                }

                if (expectedFile.readText() != actualFile.readText()) {
                    failures.add("Mismatch in ${expectedFile.name} vs ${actualFile.name}")
                }
            }

            if (failures.isNotEmpty()) {
                println("Failures in '$caseName':")
                failures.forEach { println(it) }
                fail("Case '$caseName' failed with ${failures.size} mismatches")
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
