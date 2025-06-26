package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class TranslationManagerTest {
  @Test
  void translate() {
    Unleash mockUnleash = mock(Unleash.class);
    when(mockUnleash.isEnabled("translation-enabled")).thenReturn(true);
    var instance = new TranslationManager(mockUnleash);
    assertEquals("[translated] foo", instance.translate("foo"));
  }
} 
