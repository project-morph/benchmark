package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class BonusProgramManagerTest {
  @Test
  void activateBonus() {
    Unleash unleash = mock(Unleash.class);
    when(unleash.isEnabled("bonus-activation-enabled")).thenReturn(true);
    when(unleash.isEnabled("bonus-logging-enabled")).thenReturn(true);
    var instance = new BonusProgramManager(unleash);
    assertEquals("Bonus activated for: Carol", instance.activateBonus("Carol"));
  }
}
