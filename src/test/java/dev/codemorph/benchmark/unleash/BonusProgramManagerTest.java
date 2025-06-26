package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class BonusProgramManagerTest {
  @Test
  void activateBonus() {
    var unleash = mock(Unleash.class);
    when(unleash.isEnabled(anyString())).thenReturn(true);
    var instance = new BonusProgramManager(unleash);
    assertEquals("Bonus activated for: Carol", instance.activateBonus("Carol"));
  }
}
