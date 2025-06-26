package dev.codemorph.benchmark.unleash;

public class ComplexService {
  public int compute(int a, int b) {
    int result = 0;
    if (FeatureFlags.isFlagEnabled("complex-enabled")) {
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
