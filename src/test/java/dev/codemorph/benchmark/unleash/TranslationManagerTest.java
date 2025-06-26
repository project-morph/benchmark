package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class TranslationManagerTest {
  @Test
  void translate() {
    var unleash = mock(Unleash.class);
    when(unleash.isEnabled("translation-enabled")).thenReturn(true);
    var instance = new TranslationManager(unleash);
    assertEquals("[translated] foo", instance.translate("foo"));
  }
} 
