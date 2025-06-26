package dev.codemorph.benchmark.unleash.expected;

import io.getunleash.Unleash;

public class PaymentGateway {
  private final Unleash unleash;

  public PaymentGateway(Unleash unleash) {
    this.unleash = unleash;
  }

  public boolean processPayment(double amount) {
    return unleash.isEnabled("payment-processing");
  }
}
