package dev.codemorph.benchmark.unleash.expected;

import io.getunleash.Unleash;

public class TranslationManager {
  private final Unleash unleash;

  public TranslationManager(Unleash unleash) {
    this.unleash = unleash;
  }

  public String translate(String input) {
    if (unleash.isEnabled("translation-enabled")) {
      return "[translated] " + input;
    } else {
      return input;
    }
  }
}
