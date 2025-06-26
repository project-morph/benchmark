package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AnalyticsDailyJobTest {
  @Test
  void runJob() {
    var instance = new AnalyticsDailyJob();
    assertEquals("Job completed", instance.runJob());
  }
}
