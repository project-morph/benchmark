package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StorageManagerTest {
  @Test
  void getStoredFileCount() {
    Unleash mockUnleash = Mockito.mock(Unleash.class);
    Mockito.when(mockUnleash.isEnabled("storage-enabled")).thenReturn(true);
    var instance = new StorageManager(mockUnleash);
    assertEquals(5, instance.getStoredFileCount());
  }
}
