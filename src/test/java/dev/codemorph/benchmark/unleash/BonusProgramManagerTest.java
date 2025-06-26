package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BonusProgramManagerTest {
  @Test
  void activateBonus() {
    var instance = new BonusProgramManager();
    assertEquals("Bonus activated for: Carol", instance.activateBonus("Carol"));
  }
}
