package dev.codemorph.benchmark.unleash.expected;

import io.getunleash.Unleash;

public class ComplexService {
  private final Unleash unleash;

  public ComplexService(Unleash unleash) {
    this.unleash = unleash;
  }

  public int compute(int a, int b) {
    int result = 0;
    if (unleash.isEnabled("complex-enabled")) {
      if (a > b) {
        result = a * 2;
      } else if (a == b) {
        result = a + b;
      } else {
        result = b * 2;
      }
    }
    return result;
  }
}
