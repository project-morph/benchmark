package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InvitationHandlerTest {
  @Test
  void sendInvitation() {
    Unleash unleash = Mockito.mock(Unleash.class);
    Mockito.when(unleash.isEnabled(Mockito.anyString())).thenReturn(true);
    var instance = new InvitationHandler(unleash);
    assertEquals(
        "Invitation sent to: test@example.com", instance.sendInvitation("test@example.com"));
  }
}
