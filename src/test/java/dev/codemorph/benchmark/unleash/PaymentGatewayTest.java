package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class PaymentGatewayTest {
  @Test
  void processPayment() {
    Unleash mockUnleash = mock(Unleash.class);
    when(mockUnleash.isEnabled("payment-processing")).thenReturn(true);

    var instance = new PaymentGateway(mockUnleash);
    assertTrue(instance.processPayment(42.0));
  }
}
