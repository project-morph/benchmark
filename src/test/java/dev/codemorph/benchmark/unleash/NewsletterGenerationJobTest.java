package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class NewsletterGenerationJobTest {
  @Test
  void generateSummary() {
    var unleashMock = mock(Unleash.class);
    when(unleashMock.isEnabled("newsletter-generation")).thenReturn(true);
    var instance = new NewsletterGenerationJob(unleashMock);
    assertEquals("Newsletter summary generated.", instance.generateSummary());
  }
}
