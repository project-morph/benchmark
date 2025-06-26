package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class NotificationManagerTest {
    @Test
    void sendNotification() {
        var instance = new NotificationManager();
        assertEquals("Notification sent to Alice", instance.sendNotification("Alice"));
    }
} 