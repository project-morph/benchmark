package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MediaServiceGatewayTest {
  @Test
  void getMediaUrl() {
    var instance = new MediaServiceGateway();
    assertEquals("https://media.example.com/resource", instance.getMediaUrl());
  }
}
