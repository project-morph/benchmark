package dev.codemorph.benchmark.unleash;

public class BranchingService {
  public String getStatus(int x) {
    if (FeatureFlags.isFlagEnabled("branching-enabled")) {
      if (x > 0) {
        if (FeatureFlags.isFlagEnabled("positive-status")) {
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
