package dev.codemorph.benchmark.unleash.expected;

import io.getunleash.Unleash;
import java.util.*;

public class ProjectWorkflowService {
  private final List<String> actions = new ArrayList<>();
  private int projectCount = 0;
  private final String status = "IDLE";
  private final Unleash unleash;

  public ProjectWorkflowService(Unleash unleash) {
    this.unleash = unleash;
  }

  public String startProject(String name) {
    if (unleash.isEnabled("project-start-enabled")) {
      logAction("Started project: " + name);
      projectCount++;
      return "Project started: " + name;
    } else {
      return "Project start is disabled";
    }
  }

  public String completeTask(String task) {
    if (unleash.isEnabled("task-complete-enabled")) {
      logAction("Completed task: " + task);
      return "Task completed: " + task;
    } else {
      return "Task completion is disabled";
    }
  }

  public void logAction(String action) {
    if (unleash.isEnabled("workflow-logging-enabled")) {
      actions.add(action);
    }
  }

  public String getStatus() {
    return status;
  }

  public int getProjectCount() {
    return projectCount;
  }
}
