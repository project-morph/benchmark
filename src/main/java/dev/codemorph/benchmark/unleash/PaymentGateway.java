package dev.codemorph.benchmark.unleash;

public class PaymentGateway {
  public boolean processPayment(double amount) {
    return FeatureFlags.isFlagEnabled("payment-processing");
  }
}
