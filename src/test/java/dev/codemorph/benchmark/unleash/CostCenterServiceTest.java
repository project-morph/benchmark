package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CostCenterServiceTest {
  @Test
  void addCostCenter() {
    var instance = new CostCenterService();
    assertEquals("Cost center added: IT", instance.addCostCenter("IT", 1000.0));
  }
}
