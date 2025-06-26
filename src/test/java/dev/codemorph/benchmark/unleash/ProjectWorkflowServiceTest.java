package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class ProjectWorkflowServiceTest {
  @Test
  void startProject() {
    var unleash = mock(Unleash.class);
    when(unleash.isEnabled("project-start-enabled")).thenReturn(true);
    var instance = new ProjectWorkflowService(unleash);
    assertEquals("Project started: Alpha", instance.startProject("Alpha"));
  }
}
