package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class BranchingServiceTest {
    @Test
    void getStatus() {
        var instance = new BranchingService();
        assertEquals("positive", instance.getStatus(1));
    }
} 