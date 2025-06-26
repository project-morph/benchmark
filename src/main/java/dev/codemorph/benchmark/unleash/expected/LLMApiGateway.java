package dev.codemorph.benchmark.unleash.expected;

import io.getunleash.Unleash;
import java.util.*;

public class LLMApiGateway {
  private final Map<String, Integer> quota = new HashMap<>();
  private final List<String> logs = new ArrayList<>();
  private final String status = "OK";
  private final Unleash unleash;

  public LLMApiGateway(Unleash unleash) {
    this.unleash = unleash;
    quota.put("user1", 100);
    quota.put("user2", 200);
  }

  public String callModel(String user, String prompt) {
    if (unleash.isEnabled("llm-call-enabled")) {
      logRequest(user, prompt);
      return "Response for: " + prompt;
    } else {
      return "LLM API is disabled";
    }
  }

  public int getQuota(String user) {
    if (unleash.isEnabled("quota-check-enabled")) {
      return quota.getOrDefault(user, 0);
    } else {
      return -1;
    }
  }

  public void logRequest(String user, String prompt) {
    if (unleash.isEnabled("logging-enabled")) {
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
    if (unleash.isEnabled("premium-check-enabled")) {
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
