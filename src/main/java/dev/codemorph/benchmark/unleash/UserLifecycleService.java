package dev.codemorph.benchmark.unleash;

import io.getunleash.Unleash;
import java.util.*;

public class UserLifecycleService {
  private final Set<String> users = new HashSet<>();
  private final Unleash unleash;
  private final List<String> events = new ArrayList<>();
  private final String status = "ACTIVE";

  public String registerUser(String user) {
    if (unleash.isEnabled("user-registration-enabled")) {
      users.add(user);
      logLifecycleEvent("Registered: " + user);
      return "User registered: " + user;
    } else {
      return "Registration disabled";
    }
  }

  public String deactivateUser(String user) {
    if (unleash.isEnabled("user-deactivation-enabled")) {
      users.remove(user);
      logLifecycleEvent("Deactivated: " + user);
      return "User deactivated: " + user;
    } else {
      return "Deactivation disabled";
    }
  }

  public void logLifecycleEvent(String event) {
    if (unleash.isEnabled("lifecycle-logging-enabled")) {
      events.add(event);
    }
  }

  public String getUserStatus(String user) {
    return users.contains(user) ? "active" : "inactive";
  }

  public int getUserCount() {
    return users.size();
  }
}
