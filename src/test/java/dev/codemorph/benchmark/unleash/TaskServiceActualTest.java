package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import io.getunleash.Unleash;
import static org.mockito.Mockito.*;

class TaskServiceActualTest {

    @Test
    void getRelevantTaskIds() {
        Unleash unleash = mock(Unleash.class);
        when(unleash.isEnabled("relevant-tasks")).thenReturn(true);

        var instance = new TaskServiceActual(unleash);

        assertEquals(3, instance.getRelevantTaskIds().size());
    }
}
