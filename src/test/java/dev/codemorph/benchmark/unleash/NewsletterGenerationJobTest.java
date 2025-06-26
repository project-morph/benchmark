package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class NewsletterGenerationJobTest {
  @Test
  void generateSummary() {
    Unleash mockUnleash = mock(Unleash.class);
    when(mockUnleash.isEnabled("newsletter-generation")).thenReturn(true);

    var instance = new NewsletterGenerationJob(mockUnleash);
    assertEquals("Newsletter summary generated.", instance.generateSummary());
  }
} 