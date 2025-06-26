package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class ProjectWorkflowServiceTest {
  @Test
  void startProject() {
    Unleash mockUnleash = mock(Unleash.class);
    when(mockUnleash.isEnabled(anyString())).thenReturn(true);

    var instance = new ProjectWorkflowService(mockUnleash);
    assertEquals("Project started: Alpha", instance.startProject("Alpha"));
  }
}
