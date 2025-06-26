package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class UserLifecycleServiceTest {
  @Test
  void registerUser() {
    Unleash unleash = mock(Unleash.class);
    when(unleash.isEnabled(anyString())).thenReturn(true);
    var instance = new UserLifecycleService(unleash);
    assertEquals("User registered: Bob", instance.registerUser("Bob"));
  }
}
