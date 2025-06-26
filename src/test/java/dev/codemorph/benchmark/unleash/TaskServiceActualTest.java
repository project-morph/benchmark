package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TaskServiceActualTest {

  @Test
  void getRelevantTaskIds() {
    Unleash unleash = Mockito.mock(Unleash.class);
    Mockito.when(unleash.isEnabled("relevant-tasks")).thenReturn(true);

    var instance = new TaskServiceActual(unleash);

    assertEquals(3, instance.getRelevantTaskIds().size());
  }
}
