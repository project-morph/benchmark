package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class LLMApiGatewayTest {
  @Test
  void callModel() {
    Unleash unleash = mock(Unleash.class);
    when(unleash.isEnabled("llm-call-enabled")).thenReturn(true);
    when(unleash.isEnabled("quota-check-enabled")).thenReturn(true);
    when(unleash.isEnabled("logging-enabled")).thenReturn(true);
    when(unleash.isEnabled("premium-check-enabled")).thenReturn(true);
    var instance = new LLMApiGateway(unleash);
    assertEquals("Response for: test", instance.callModel("user1", "test"));
  }
}
