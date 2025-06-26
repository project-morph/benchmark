package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PaymentGatewayTest {
    @Test
    void processPayment() {
        var instance = new PaymentGateway();
        assertTrue(instance.processPayment(42.0));
    }
} 