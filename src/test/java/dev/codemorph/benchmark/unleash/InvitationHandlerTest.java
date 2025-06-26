package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InvitationHandlerTest {
  @Mock private Unleash unleash;
  private InvitationHandler instance;

  @BeforeEach
  void setUp() {
    when(unleash.isEnabled(anyString())).thenReturn(true);
    instance = new InvitationHandler(unleash);
  }

  @Test
  void sendInvitation() {
    assertEquals(
        "Invitation sent to: test@example.com", instance.sendInvitation("test@example.com"));
  }
}
