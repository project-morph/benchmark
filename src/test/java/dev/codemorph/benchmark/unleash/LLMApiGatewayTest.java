package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class LLMApiGatewayTest {
  @Test
  void callModel() {
    Unleash unleash = mock(Unleash.class);
    when(unleash.isEnabled(anyString())).thenReturn(true);
    var instance = new LLMApiGateway(unleash);
    assertEquals("Response for: test", instance.callModel("user1", "test"));
  }
}
