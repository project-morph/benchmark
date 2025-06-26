package dev.codemorph.benchmark.unleash;

import io.getunleash.Unleash;
import java.util.List;

public class EventLogService {
  private final Unleash unleash;

  public EventLogService(Unleash unleash) {
    this.unleash = unleash;
  }

  public List<String> getRecentEvents() {
    if (unleash.isEnabled("event-logging")) {
      return List.of("event1", "event2", "event3");
    } else {
      return List.of();
    }
  }
}
