package dev.codemorph.benchmark.unleash;

public class MediaServiceGateway {
  public String getMediaUrl() {
    if (FeatureFlags.isFlagEnabled("media-service-enabled")) {
      return "https://media.example.com/resource";
    } else {
      return null;
    }
  }
}
