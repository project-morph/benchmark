package dev.codemorph.benchmark

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.TestFactory


resources:
  requests:
    cpu: "500m"
    memory: "1Gi"
  limits:
    cpu: "2"
    memory: "2Gi"

class TestYamlChangeValue {
    @TestFactory
    fun testYamlChangeValue() = TestRunner.runCase("yaml_change_value")
}
