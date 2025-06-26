package dev.codemorph.benchmark.unleash;

import io.getunleash.Unleash;

public class BillingService {

  private final Unleash unleash;

  public BillingService(Unleash unleash) {
    this.unleash = unleash;
  }

  public int getBillAmount() {
    if (unleash.isEnabled("billing-enabled")) {
      return 100;
    } else {
      return 0;
    }
  }
}
