package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class BillingServiceTest {
  @Test
  void getBillAmount() {
    Unleash unleash = mock(Unleash.class);
    when(unleash.isEnabled("billing-enabled")).thenReturn(true);
    var instance = new BillingService(unleash);
    assertEquals(100, instance.getBillAmount());
  }
} 