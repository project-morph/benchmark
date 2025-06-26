package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class BonusProgramManagerTest {
  @Test
  void activateBonus() {
    Unleash unleashMock = mock(Unleash.class);
    when(unleashMock.isEnabled(anyString())).thenReturn(true);
    var instance = new BonusProgramManager(unleashMock);
    assertEquals("Bonus activated for: Carol", instance.activateBonus("Carol"));
  }
}
