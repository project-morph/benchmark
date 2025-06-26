package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LLMApiGatewayTest {
  @Test
  void callModel() {
    var instance = new LLMApiGateway();
    assertEquals("Response for: test", instance.callModel("user1", "test"));
  }
}
