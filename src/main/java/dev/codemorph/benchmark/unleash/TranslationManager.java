package dev.codemorph.benchmark.unleash;

public class TranslationManager {
  public String translate(String input) {
    if (FeatureFlags.isFlagEnabled("translation-enabled")) {
      return "[translated] " + input;
    } else {
      return input;
    }
  }
}
