package dev.codemorph.benchmark.unleash;

public class SubscriptionService {
  public String getSubscriptionStatus() {
    if (FeatureFlags.isFlagEnabled("subscription-active")) {
      return "active";
    } else {
      return "inactive";
    }
  }
}
