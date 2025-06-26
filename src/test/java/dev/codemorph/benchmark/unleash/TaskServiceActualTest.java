package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class TaskServiceActualTest {

  @Test
  void getRelevantTaskIds() {
    Unleash mockUnleash = mock(Unleash.class);
    when(mockUnleash.isEnabled("relevant-tasks")).thenReturn(true);

    var instance = new TaskServiceActual(mockUnleash);

    assertEquals(3, instance.getRelevantTaskIds().size());
  }
}
