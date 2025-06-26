package dev.codemorph.benchmark.unleash;

public class BillingService {
  public int getBillAmount() {
    if (FeatureFlags.isFlagEnabled("billing-enabled")) {
      return 100;
    } else {
      return 0;
    }
  }
}
