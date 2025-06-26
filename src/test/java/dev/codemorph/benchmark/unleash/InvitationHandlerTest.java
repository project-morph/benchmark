package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InvitationHandlerTest {
  @Test
  void sendInvitation() {
    var mockUnleash = Mockito.mock(Unleash.class);
    Mockito.when(mockUnleash.isEnabled(Mockito.anyString())).thenReturn(true);
    var instance = new InvitationHandler(mockUnleash);
    assertEquals(
        "Invitation sent to: test@example.com", instance.sendInvitation("test@example.com"));
  }
}
