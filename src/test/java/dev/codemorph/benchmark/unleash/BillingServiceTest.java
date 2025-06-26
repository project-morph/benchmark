package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class BillingServiceTest {
    @Test
    void getBillAmount() {
        var instance = new BillingService();
        assertEquals(100, instance.getBillAmount());
    }
} 