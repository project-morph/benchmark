package dev.codemorph.benchmark.unleash;

import io.getunleash.Unleash;
import java.util.*;

public class InvitationHandler {
  private final Set<String> pending = new HashSet<>();
  private final List<String> logs = new ArrayList<>();
  private final String status = "OPEN";

  private Unleash unleash;

  public InvitationHandler(Unleash unleash) {
    this.unleash = unleash;
  }

  public String sendInvitation(String email) {
    if (unleash.isEnabled("invitation-send-enabled")) {
      pending.add(email);
      logInvitation("Sent to: " + email);
      return "Invitation sent to: " + email;
    } else {
      return "Invitation sending disabled";
    }
  }

  public String acceptInvitation(String email) {
    if (unleash.isEnabled("invitation-accept-enabled")) {
      pending.remove(email);
      logInvitation("Accepted by: " + email);
      return "Invitation accepted: " + email;
    } else {
      return "Invitation acceptance disabled";
    }
  }

  public void logInvitation(String event) {
    if (unleash.isEnabled("invitation-logging-enabled")) {
      logs.add(event);
    }
  }

  public String getStatus() {
    return status;
  }

  public int getPendingCount() {
    return pending.size();
  }
}
