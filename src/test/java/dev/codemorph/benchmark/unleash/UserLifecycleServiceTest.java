package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class UserLifecycleServiceTest {
  @Test
  void registerUser() {
    Unleash unleashMock = mock(Unleash.class);
    when(unleashMock.isEnabled("user-registration-enabled")).thenReturn(true);
    var instance = new UserLifecycleService(unleashMock);
    assertEquals("User registered: Bob", instance.registerUser("Bob"));
  }
}
