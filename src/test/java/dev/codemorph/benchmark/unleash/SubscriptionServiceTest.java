package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SubscriptionServiceTest {
    @Test
    void getSubscriptionStatus() {
        var instance = new SubscriptionService();
        assertEquals("active", instance.getSubscriptionStatus());
    }
} 