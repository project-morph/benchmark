package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class TaskServiceActualTest {

    @Test
    void getRelevantTaskIds() {
        var unleash = mock(Unleash.class);
        when(unleash.isEnabled("relevant-tasks")).thenReturn(true);
        
        var instance = new TaskServiceActual(unleash);

        assertEquals(3, instance.getRelevantTaskIds().size());
    }
}
