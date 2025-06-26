package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import io.getunleash.Unleash;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MediaServiceGatewayTest {
  @Test
  void getMediaUrl() {
    Unleash unleash = mock(Unleash.class);
    when(unleash.isEnabled("media-service-enabled")).thenReturn(true);
    var instance = new MediaServiceGateway(unleash);
    assertEquals("https://media.example.com/resource", instance.getMediaUrl());
  }
} 