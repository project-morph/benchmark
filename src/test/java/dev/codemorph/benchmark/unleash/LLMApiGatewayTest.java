package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class LLMApiGatewayTest {
  @Test
  void callModel() {
    Unleash unleashMock = mock(Unleash.class);
    when(unleashMock.isEnabled(anyString())).thenReturn(true);
    var instance = new LLMApiGateway(unleashMock);
    assertEquals("Response for: test", instance.callModel("user1", "test"));
  }
}
