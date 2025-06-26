package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class CostCenterServiceTest {
  @Test
  void addCostCenter() {
    Unleash mockUnleash = mock(Unleash.class);
    when(mockUnleash.isEnabled(anyString())).thenReturn(true);
    var instance = new CostCenterService(mockUnleash);
    assertEquals("Cost center added: IT", instance.addCostCenter("IT", 1000.0));
  }
}
