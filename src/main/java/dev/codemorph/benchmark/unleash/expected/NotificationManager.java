package dev.codemorph.benchmark.unleash.expected;

import io.getunleash.Unleash;

public class NotificationManager {
  private final Unleash unleash;

  public NotificationManager(Unleash unleash) {
    this.unleash = unleash;
  }

  public String sendNotification(String user) {
    if (unleash.isEnabled("notifications-enabled")) {
      return "Notification sent to " + user;
    } else {
      return null;
    }
  }
}
