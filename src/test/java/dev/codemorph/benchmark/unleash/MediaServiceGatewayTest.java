package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class MediaServiceGatewayTest {
  @Test
  void getMediaUrl() {
    var unleash = mock(Unleash.class);
    when(unleash.isEnabled("media-service-enabled")).thenReturn(true);
    var instance = new MediaServiceGateway(unleash);
    assertEquals("https://media.example.com/resource", instance.getMediaUrl());
  }
} 