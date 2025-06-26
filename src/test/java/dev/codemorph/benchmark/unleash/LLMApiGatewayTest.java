package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LLMApiGatewayTest {
  @Test
  void callModel() {
    var unleash = Mockito.mock(Unleash.class);
    Mockito.when(unleash.isEnabled(Mockito.anyString())).thenReturn(true);
    var instance = new LLMApiGateway(unleash);
    assertEquals("Response for: test", instance.callModel("user1", "test"));
  }
}
