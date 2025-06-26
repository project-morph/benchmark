package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class StorageManagerTest {
    @Test
    void getStoredFileCount() {
        var instance = new StorageManager();
        assertEquals(5, instance.getStoredFileCount());
    }
} 