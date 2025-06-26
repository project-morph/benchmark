package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PaymentGatewayTest {
  @Test
  void processPayment() {
    Unleash mockUnleash = Mockito.mock(Unleash.class);
    Mockito.when(mockUnleash.isEnabled("payment-processing")).thenReturn(true);
    var instance = new PaymentGateway(mockUnleash);
    assertTrue(instance.processPayment(42.0));
  }
}
