package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SubscriptionServiceTest {
  @Test
  void getSubscriptionStatus() {
    var unleash = org.mockito.Mockito.mock(io.getunleash.Unleash.class);
    org.mockito.Mockito.when(unleash.isEnabled("subscription-active")).thenReturn(true);
    var instance = new SubscriptionService(unleash);
    assertEquals("active", instance.getSubscriptionStatus());
  }
}
