package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import io.getunleash.Unleash;

class TaskServiceActualTest {

    @Test
    void getRelevantTaskIds() {
        var unleash = Mockito.mock(Unleash.class);
        Mockito.when(unleash.isEnabled("relevant-tasks")).thenReturn(true);
        var instance = new TaskServiceActual(unleash);

        assertEquals(3, instance.getRelevantTaskIds().size());
    }
}
