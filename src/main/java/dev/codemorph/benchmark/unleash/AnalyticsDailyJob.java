package dev.codemorph.benchmark.unleash;

import io.getunleash.Unleash;
import java.util.*;

public class AnalyticsDailyJob {
  private final List<String> reports = new ArrayList<>();
  private int stats = 0;
  private final String status = "READY";
  private final Unleash unleash;

  public String runJob() {
    if (FeatureFlags.isFlagEnabled("analytics-job-enabled")) {
      logAnalytics("Job started");
      stats++;
      return "Job completed";
    } else {
      return "Analytics job is disabled";
    }
  }

  public String getReport() {
    if (unleash.isEnabled("report-generation-enabled")) {
      String report = "Report: " + stats;
      reports.add(report);
      return report;
    } else {
      return "Report generation is disabled";
    }
  }

  public void logAnalytics(String message) {
    if (unleash.isEnabled("analytics-logging-enabled")) {
      reports.add(message);
    }
  }

  public String getStatus() {
    return status;
  }

  public void resetStats() {
    stats = 0;
  }
}
