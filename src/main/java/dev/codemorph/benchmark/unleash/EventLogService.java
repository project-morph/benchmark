package dev.codemorph.benchmark.unleash;

import java.util.List;

public class EventLogService {
  public List<String> getRecentEvents() {
    if (FeatureFlags.isFlagEnabled("event-logging")) {
      return List.of("event1", "event2", "event3");
    } else {
      return List.of();
    }
  }
}
