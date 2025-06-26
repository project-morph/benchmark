package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class TaskServiceActualTest {

  @Test
  void getRelevantTaskIds() {
    var unleash = mock(Unleash.class);
    when(unleash.isEnabled(anyString())).thenReturn(true);
    var instance = new TaskServiceActual(unleash);

    assertEquals(3, instance.getRelevantTaskIds().size());
  }
}
