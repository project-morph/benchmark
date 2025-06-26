package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BillingServiceTest {
  @Test
  void getBillAmount() {
    Unleash unleash = Mockito.mock(Unleash.class);
    Mockito.when(unleash.isEnabled("billing-enabled")).thenReturn(true);
    var instance = new BillingService(unleash);
    assertEquals(100, instance.getBillAmount());
  }
}
