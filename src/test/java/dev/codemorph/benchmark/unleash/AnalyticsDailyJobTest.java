package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AnalyticsDailyJobTest {
  @Test
  void runJob() {
    Unleash unleash = Mockito.mock(Unleash.class);
    Mockito.when(unleash.isEnabled(Mockito.anyString())).thenReturn(true);
    var instance = new AnalyticsDailyJob(unleash);
    assertEquals("Job completed", instance.runJob());
  }
}
