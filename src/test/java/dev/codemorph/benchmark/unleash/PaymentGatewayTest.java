package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PaymentGatewayTest {
  @Test
  void processPayment() {
    Unleash unleash = Mockito.mock(Unleash.class);
    Mockito.when(unleash.isEnabled("payment-processing")).thenReturn(true);
    var instance = new PaymentGateway(unleash);
    assertTrue(instance.processPayment(42.0));
  }
}
