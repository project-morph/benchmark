package dev.codemorph.benchmark

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.TestFactory

class TestYamlChangeValue {
    @TestFactory
    @Disabled
    fun testYamlChangeValue() = TestRunner.runCase("yaml_change_value")
}
