package dev.codemorph.benchmark.unleash;

import java.util.*;

public class ProjectWorkflowService {
  private final List<String> actions = new ArrayList<>();
  private int projectCount = 0;
  private final String status = "IDLE";

  public String startProject(String name) {
    if (FeatureFlags.isFlagEnabled("project-start-enabled")) {
      logAction("Started project: " + name);
      projectCount++;
      return "Project started: " + name;
    } else {
      return "Project start is disabled";
    }
  }

  public String completeTask(String task) {
    if (FeatureFlags.isFlagEnabled("task-complete-enabled")) {
      logAction("Completed task: " + task);
      return "Task completed: " + task;
    } else {
      return "Task completion is disabled";
    }
  }

  public void logAction(String action) {
    if (FeatureFlags.isFlagEnabled("workflow-logging-enabled")) {
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
