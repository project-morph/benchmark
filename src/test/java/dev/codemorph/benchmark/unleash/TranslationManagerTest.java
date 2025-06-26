package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TranslationManagerTest {
  @Test
  void translate() {
    Unleash unleash = Mockito.mock(Unleash.class);
    Mockito.when(unleash.isEnabled("translation-enabled")).thenReturn(true);
    var instance = new TranslationManager(unleash);
    assertEquals("[translated] foo", instance.translate("foo"));
  }
}
