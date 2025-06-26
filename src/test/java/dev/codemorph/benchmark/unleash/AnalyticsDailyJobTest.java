package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class AnalyticsDailyJobTest {
  @Test
  void runJob() {
    Unleash unleash = mock(Unleash.class);
    when(unleash.isEnabled("analytics-job-enabled")).thenReturn(true);
    when(unleash.isEnabled("report-generation-enabled")).thenReturn(true);
    when(unleash.isEnabled("analytics-logging-enabled")).thenReturn(true);
    var instance = new AnalyticsDailyJob(unleash);
    assertEquals("Job completed", instance.runJob());
  }
}
