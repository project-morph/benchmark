package dev.codemorph.benchmark.unleash;

import io.getunleash.Unleash;

public class TranslationManager {
  public String translate(String input) {
    if (unleash.isEnabled("translation-enabled")) {
      return "[translated] " + input;
    } else {
      return input;
    }
  }

  private final Unleash unleash;

  public TranslationManager(Unleash unleash) {
    this.unleash = unleash;
  }
}
