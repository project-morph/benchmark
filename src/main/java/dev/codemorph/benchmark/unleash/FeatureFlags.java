package dev.codemorph.benchmark.unleash;

import io.getunleash.Unleash;

public class FeatureFlags {
  private final Unleash unleash;

  public FeatureFlags(Unleash unleash) {
    this.unleash = unleash;
  }

  public boolean isFlagEnabled(String flag) {
    return unleash.isEnabled(flag);
  }
}
