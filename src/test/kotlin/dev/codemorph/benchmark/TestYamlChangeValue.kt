package dev.codemorph.benchmark

import org.junit.jupiter.api.TestFactory

class TestYamlChangeValue {
    @TestFactory
    fun testYamlChangeValue() = TestRunner.runCase("yaml_change_value")
}
