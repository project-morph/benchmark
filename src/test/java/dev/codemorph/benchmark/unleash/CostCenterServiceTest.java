package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CostCenterServiceTest {
  @Test
  void addCostCenter() {
    Unleash mockUnleash = Mockito.mock(Unleash.class);
    Mockito.when(mockUnleash.isEnabled(Mockito.anyString())).thenReturn(true);
    var instance = new CostCenterService(mockUnleash);
    assertEquals("Cost center added: IT", instance.addCostCenter("IT", 1000.0));
  }
}
