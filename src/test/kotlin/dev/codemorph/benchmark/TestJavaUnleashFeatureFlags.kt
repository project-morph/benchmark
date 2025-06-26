package dev.codemorph.benchmark

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.TestFactory

class TestJavaUnleashFeatureFlags {
    @TestFactory
    @Disabled
    fun testJavaUnleashFeatureFlags() = TestRunner.runCaseJava(
        "src/main/java/dev/codemorph/benchmark/unleash/expected",
        "src/main/java/dev/codemorph/benchmark/unleash"
    )
}
