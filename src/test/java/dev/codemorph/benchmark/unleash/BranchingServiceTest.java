package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class BranchingServiceTest {
  @Test
  void getStatus() {
    Unleash unleash = mock(Unleash.class);
    when(unleash.isEnabled("branching-enabled")).thenReturn(true);
    when(unleash.isEnabled("positive-status")).thenReturn(true);
    var instance = new BranchingService(unleash);
    assertEquals("positive", instance.getStatus(1));
  }
}
