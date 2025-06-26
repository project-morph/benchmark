package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class InvitationHandlerTest {
  @Test
  void sendInvitation() {
    var instance = new InvitationHandler();
    assertEquals(
        "Invitation sent to: test@example.com", instance.sendInvitation("test@example.com"));
  }
}
