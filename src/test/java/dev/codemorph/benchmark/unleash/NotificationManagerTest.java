package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class NotificationManagerTest {
  @Test
  void sendNotification() {
    var unleash = mock(Unleash.class);
    when(unleash.isEnabled("notifications-enabled")).thenReturn(true);
    var instance = new NotificationManager(unleash);
    assertEquals("Notification sent to Alice", instance.sendNotification("Alice"));
  }
}
