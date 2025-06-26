package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class InvitationHandlerTest {
  @Test
  void sendInvitation() {
    Unleash unleash = mock(Unleash.class);
    when(unleash.isEnabled("invitation-send-enabled")).thenReturn(true);
    var instance = new InvitationHandler(unleash);
    assertEquals(
        "Invitation sent to: test@example.com", instance.sendInvitation("test@example.com"));
  }
}
