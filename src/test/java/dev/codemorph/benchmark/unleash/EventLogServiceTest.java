package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class EventLogServiceTest {
  @Test
  void getRecentEvents() {
    var unleash = mock(Unleash.class);
    when(unleash.isEnabled("event-logging")).thenReturn(true);
    var instance = new EventLogService(unleash);
    assertEquals(3, instance.getRecentEvents().size());
  }
} 