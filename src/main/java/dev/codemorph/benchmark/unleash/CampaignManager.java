package dev.codemorph.benchmark.unleash;

import java.util.*;

public class CampaignManager {
  private final Set<String> campaigns = new HashSet<>();
  private final List<String> logs = new ArrayList<>();
  private final String status = "READY";

  public String launchCampaign(String name) {
    if (FeatureFlags.isFlagEnabled("campaign-launch-enabled")) {
      campaigns.add(name);
      logCampaignEvent("Launched: " + name);
      return "Campaign launched: " + name;
    } else {
      return "Campaign launch disabled";
    }
  }

  public String getCampaignStatus(String name) {
    if (FeatureFlags.isFlagEnabled("campaign-status-check-enabled")) {
      return campaigns.contains(name) ? "active" : "inactive";
    } else {
      return "Status check disabled";
    }
  }

  public void logCampaignEvent(String event) {
    if (FeatureFlags.isFlagEnabled("campaign-logging-enabled")) {
      logs.add(event);
    }
  }

  public String getStatus() {
    return status;
  }

  public int getCampaignCount() {
    return campaigns.size();
  }
}
