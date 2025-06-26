package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProjectWorkflowServiceTest {
  @Test
  void startProject() {
    var instance = new ProjectWorkflowService();
    assertEquals("Project started: Alpha", instance.startProject("Alpha"));
  }
}
