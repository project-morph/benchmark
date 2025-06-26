package dev.codemorph.benchmark.unleash;

import io.getunleash.Unleash;

public class NewsletterGenerationJob {
  private final Unleash unleash;

  public NewsletterGenerationJob(Unleash unleash) {
    this.unleash = unleash;
  }
  public String generateSummary() {
    if (unleash.isEnabled("newsletter-generation")) {
      return "Newsletter summary generated.";
    } else {
      return null;
    }
  }
}
