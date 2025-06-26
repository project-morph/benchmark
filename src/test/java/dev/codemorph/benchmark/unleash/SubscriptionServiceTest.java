package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class SubscriptionServiceTest {
  @Test
  void getSubscriptionStatus() {
    var unleash = mock(Unleash.class);
    when(unleash.isEnabled("subscription-active")).thenReturn(true);
    var instance = new SubscriptionService(unleash);
    assertEquals("active", instance.getSubscriptionStatus());
  }
} 