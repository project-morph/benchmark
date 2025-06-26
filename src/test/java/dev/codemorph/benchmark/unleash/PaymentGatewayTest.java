package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class PaymentGatewayTest {
  @Test
  void processPayment() {
    var instance = new PaymentGateway();
    assertTrue(instance.processPayment(42.0));
  }
}
