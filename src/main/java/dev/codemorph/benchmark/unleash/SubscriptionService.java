package dev.codemorph.benchmark.unleash;

import io.getunleash.Unleash;

public class SubscriptionService {
  private final Unleash unleash;

  public SubscriptionService(Unleash unleash) {
    this.unleash = unleash;
  }

  public String getSubscriptionStatus() {
    if (unleash.isEnabled("subscription-active")) {
      return "active";
    } else {
      return "inactive";
    }
  }
}
