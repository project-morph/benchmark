package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import io.getunleash.Unleash;

class BranchingServiceTest {
    @Test
    void getStatus() {
        Unleash mockUnleash = mock(Unleash.class);
        when(mockUnleash.isEnabled(anyString())).thenReturn(true);

        var instance = new BranchingService(mockUnleash);
        assertEquals("positive", instance.getStatus(1));
    }
} 