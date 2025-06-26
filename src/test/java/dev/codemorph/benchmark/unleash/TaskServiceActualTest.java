package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import io.getunleash.Unleash;

class TaskServiceActualTest {

  @Test
  void getRelevantTaskIds() {
    Unleash unleashMock = mock(Unleash.class);
    when(unleashMock.isEnabled("relevant-tasks")).thenReturn(true);

    var instance = new TaskServiceActual(unleashMock);

    assertEquals(3, instance.getRelevantTaskIds().size());
  }
}
