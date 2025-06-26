package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserLifecycleServiceTest {
  @Test
  void registerUser() {
    var instance = new UserLifecycleService();
    assertEquals("User registered: Bob", instance.registerUser("Bob"));
  }
}
