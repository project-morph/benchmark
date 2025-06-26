package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class EventLogServiceTest {
    @Test
    void getRecentEvents() {
        var instance = new EventLogService();
        assertEquals(3, instance.getRecentEvents().size());
    }
} 