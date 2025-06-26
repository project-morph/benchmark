package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CostCenterServiceTest {
  @Test
  void addCostCenter() {
    Unleash unleash = Mockito.mock(Unleash.class);
    Mockito.when(unleash.isEnabled(Mockito.anyString())).thenReturn(true);
    var instance = new CostCenterService(unleash);
    assertEquals("Cost center added: IT", instance.addCostCenter("IT", 1000.0));
  }
}
