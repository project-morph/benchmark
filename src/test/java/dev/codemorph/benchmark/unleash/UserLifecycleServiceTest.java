package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserLifecycleServiceTest {
  @Test
  void registerUser() {
    Unleash unleash = Mockito.mock(Unleash.class);
    Mockito.when(unleash.isEnabled(Mockito.anyString())).thenReturn(true);
    var instance = new UserLifecycleService(unleash);
    assertEquals("User registered: Bob", instance.registerUser("Bob"));
  }
}
