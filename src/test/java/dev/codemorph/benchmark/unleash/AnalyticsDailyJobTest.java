package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class AnalyticsDailyJobTest {
  @Test
  void runJob() {
    Unleash mockUnleash = mock(Unleash.class);
    when(mockUnleash.isEnabled("analytics-job-enabled")).thenReturn(true);

    var instance = new AnalyticsDailyJob(mockUnleash);
    assertEquals("Job completed", instance.runJob());
  }
}
