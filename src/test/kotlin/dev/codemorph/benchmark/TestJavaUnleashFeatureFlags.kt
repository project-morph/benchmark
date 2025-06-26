package dev.codemorph.benchmark

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.TestFactory

class TestJavaUnleashFeatureFlags {
    @TestFactory
    fun testJavaUnleashFeatureFlags() = TestRunner.runCase("src/main/java/dev/codemorph/benchmark/unleash")
}
