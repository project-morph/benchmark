package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TranslationManagerTest {
    @Test
    void translate() {
        var instance = new TranslationManager();
        assertEquals("[translated] foo", instance.translate("foo"));
    }
} 
