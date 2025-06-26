package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class NewsletterGenerationJobTest {
  @Test
  void generateSummary() {
    Unleash unleash = mock(Unleash.class);
    when(unleash.isEnabled(anyString())).thenReturn(true);
    var instance = new NewsletterGenerationJob(unleash);
    assertEquals("Newsletter summary generated.", instance.generateSummary());
  }
}
