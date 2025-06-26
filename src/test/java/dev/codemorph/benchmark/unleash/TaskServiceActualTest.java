package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TaskServiceActualTest {

  @Test
  void getRelevantTaskIds() {
    var instance = new TaskServiceActual();

    assertEquals(3, instance.getRelevantTaskIds().size());
  }
}
