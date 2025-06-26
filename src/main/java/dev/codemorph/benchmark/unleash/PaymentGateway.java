package dev.codemorph.benchmark.unleash;

import io.getunleash.Unleash;

public class PaymentGateway {
  public boolean processPayment(double amount) {
    return FeatureFlags.isFlagEnabled("payment-processing");
  }
}
