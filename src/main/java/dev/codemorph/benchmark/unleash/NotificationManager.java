package dev.codemorph.benchmark.unleash;

public class NotificationManager {
  public String sendNotification(String user) {
    if (FeatureFlags.isFlagEnabled("notifications-enabled")) {
      return "Notification sent to " + user;
    } else {
      return null;
    }
  }
}
