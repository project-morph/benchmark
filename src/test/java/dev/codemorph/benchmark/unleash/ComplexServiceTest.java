package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class ComplexServiceTest {
  @Test
  void compute() {
    Unleash mockUnleash = mock(Unleash.class);
    when(mockUnleash.isEnabled("complex-enabled")).thenReturn(true);

    var instance = new ComplexService(mockUnleash);
    assertEquals(6, instance.compute(3, 2));
  }
}
