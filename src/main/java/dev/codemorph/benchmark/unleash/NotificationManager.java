package dev.codemorph.benchmark.unleash;

import io.getunleash.Unleash;

public class NotificationManager {
  private Unleash unleash;

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
