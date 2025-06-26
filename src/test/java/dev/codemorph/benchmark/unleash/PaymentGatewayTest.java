package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class PaymentGatewayTest {
  @Test
  void processPayment() {
    var unleash = mock(Unleash.class);
    when(unleash.isEnabled("payment-processing")).thenReturn(true);
    var instance = new PaymentGateway(unleash);
    assertTrue(instance.processPayment(42.0));
  }
} 