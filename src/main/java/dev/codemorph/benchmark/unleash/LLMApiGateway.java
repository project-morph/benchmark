package dev.codemorph.benchmark.unleash;

import java.util.*;

public class LLMApiGateway {
  private final Map<String, Integer> quota = new HashMap<>();
  private final List<String> logs = new ArrayList<>();
  private final String status = "OK";

  public LLMApiGateway() {
    quota.put("user1", 100);
    quota.put("user2", 200);
  }

  public String callModel(String user, String prompt) {
    if (FeatureFlags.isFlagEnabled("llm-call-enabled")) {
      logRequest(user, prompt);
      return "Response for: " + prompt;
    } else {
      return "LLM API is disabled";
    }
  }

  public int getQuota(String user) {
    if (FeatureFlags.isFlagEnabled("quota-check-enabled")) {
      return quota.getOrDefault(user, 0);
    } else {
      return -1;
    }
  }

  public void logRequest(String user, String prompt) {
    if (FeatureFlags.isFlagEnabled("logging-enabled")) {
      logs.add(user + ": " + prompt);
    }
  }

  public String getStatus() {
    return status;
  }

  public List<String> getLogs() {
    return new ArrayList<>(logs);
  }

  public void resetQuota(String user) {
    quota.put(user, 100);
  }

  public boolean isPremiumUser(String user) {
    if (FeatureFlags.isFlagEnabled("premium-check-enabled")) {
      return user.startsWith("premium");
    } else {
      return false;
    }
  }

  public int getTotalQuota() {
    int total = 0;
    for (int q : quota.values()) {
      total += q;
    }
    return total;
  }

  public void clearLogs() {
    logs.clear();
  }
}
