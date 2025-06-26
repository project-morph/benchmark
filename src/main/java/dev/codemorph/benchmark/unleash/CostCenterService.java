package dev.codemorph.benchmark.unleash;

import io.getunleash.Unleash;
import java.util.*;

public class CostCenterService {
  private final Map<String, Double> centers = new HashMap<>();
  private final List<String> logs = new ArrayList<>();
  private final String status = "ACTIVE";

  private Unleash unleash;

  public CostCenterService(Unleash unleash) {
    this.unleash = unleash;
  }

  public String addCostCenter(String name, double cost) {
    if (unleash.isEnabled("cost-center-add-enabled")) {
      centers.put(name, cost);
      logCostEvent("Added: " + name);
      return "Cost center added: " + name;
    } else {
      return "Adding cost center disabled";
    }
  }

  public double getCost(String name) {
    if (unleash.isEnabled("cost-check-enabled")) {
      return centers.getOrDefault(name, 0.0);
    } else {
      return -1.0;
    }
  }

  public void logCostEvent(String event) {
    if (unleash.isEnabled("cost-logging-enabled")) {
      logs.add(event);
    }
  }

  public String getStatus() {
    return status;
  }

  public int getCenterCount() {
    return centers.size();
  }
}
