package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class BillingServiceTest {
  @Test
  void getBillAmount() {
    var mockUnleash = mock(Unleash.class);
    when(mockUnleash.isEnabled("billing-enabled")).thenReturn(true);

    var instance = new BillingService(mockUnleash);
    assertEquals(100, instance.getBillAmount());
  }
}
