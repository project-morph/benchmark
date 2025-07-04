package dev.codemorph.benchmark.unleash.expected;

import io.getunleash.Unleash;

public class MediaServiceGateway {
  private final Unleash unleash;

  public MediaServiceGateway(Unleash unleash) {
    this.unleash = unleash;
  }

  public String getMediaUrl() {
    if (unleash.isEnabled("media-service-enabled")) {
      return "https://media.example.com/resource";
    } else {
      return null;
    }
  }
}
