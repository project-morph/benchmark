package dev.codemorph.benchmark.unleash;

public class StorageManager {
  public int getStoredFileCount() {
    if (FeatureFlags.isFlagEnabled("storage-enabled")) {
      return 5;
    } else {
      return 0;
    }
  }
}
