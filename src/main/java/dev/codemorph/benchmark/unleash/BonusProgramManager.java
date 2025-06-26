package dev.codemorph.benchmark.unleash;

import java.util.*;
import io.getunleash.Unleash;

public class BonusProgramManager {
  private final Map<String, Integer> points = new HashMap<>();
  private final List<String> events = new ArrayList<>();
  private final String status = "ENABLED";
  private final Unleash unleash;

  public BonusProgramManager(Unleash unleash) {
    this.unleash = unleash;
  }

  public String activateBonus(String user) {
    if (unleash.isEnabled("bonus-activation-enabled")) {
      points.put(user, points.getOrDefault(user, 0) + 10);
      logBonusEvent("Activated bonus for: " + user);
      return "Bonus activated for: " + user;
    } else {
      return "Bonus activation disabled";
    }
  }

  public int getBonusPoints(String user) {
    if (unleash.isEnabled("bonus-points-check-enabled")) {
      return points.getOrDefault(user, 0);
    } else {
      return -1;
    }
  }

  public void logBonusEvent(String event) {
    if (unleash.isEnabled("bonus-logging-enabled")) {
      events.add(event);
    }
  }

  public String getStatus() {
    return status;
  }

  public void resetPoints(String user) {
    points.put(user, 0);
  }
}
