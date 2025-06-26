package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class StorageManagerTest {
  @Test
  void getStoredFileCount() {
    Unleash unleash = mock(Unleash.class);
    when(unleash.isEnabled(anyString())).thenReturn(true);
    var instance = new StorageManager(unleash);
    assertEquals(5, instance.getStoredFileCount());
  }
}
