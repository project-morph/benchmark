package dev.codemorph.benchmark.unleash;

public class NewsletterGenerationJob {
  public String generateSummary() {
    if (FeatureFlags.isFlagEnabled("newsletter-generation")) {
      return "Newsletter summary generated.";
    } else {
      return null;
    }
  }
}
