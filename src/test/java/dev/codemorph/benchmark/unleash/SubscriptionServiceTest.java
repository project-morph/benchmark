package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class SubscriptionServiceTest {
  @Test
  void getSubscriptionStatus() {
    Unleash mockUnleash = mock(Unleash.class);
    when(mockUnleash.isEnabled("subscription-active")).thenReturn(true);

    var instance = new SubscriptionService(mockUnleash);
    assertEquals("active", instance.getSubscriptionStatus());
  }
} 