package dev.codemorph.benchmark.unleash;

import io.getunleash.Unleash;

public class StorageManager {
  private Unleash unleash;

  public StorageManager(Unleash unleash) {
    this.unleash = unleash;
  }

  public int getStoredFileCount() {
    if (unleash.isEnabled("storage-enabled")) {
      return 5;
    } else {
      return 0;
    }
  }
}
