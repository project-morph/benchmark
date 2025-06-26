package dev.codemorph.benchmark.unleash.expected;

import io.getunleash.Unleash;

public class BranchingService {
  private final Unleash unleash;

  public BranchingService(Unleash unleash) {
    this.unleash = unleash;
  }

  public String getStatus(int x) {
    if (unleash.isEnabled("branching-enabled")) {
      if (x > 0) {
        if (unleash.isEnabled("positive-status")) {
          return "positive";
        } else {
          return "non-positive";
        }
      } else {
        return "zero or negative";
      }
    }
    return "disabled";
  }
}
