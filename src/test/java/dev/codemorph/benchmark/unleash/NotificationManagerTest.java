package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NotificationManagerTest {
    @Test
    void sendNotification() {
        Unleash mockUnleash = Mockito.mock(Unleash.class);
        Mockito.when(mockUnleash.isEnabled("notifications-enabled")).thenReturn(true);
        var instance = new NotificationManager(mockUnleash);
        assertEquals("Notification sent to Alice", instance.sendNotification("Alice"));
    }
} 