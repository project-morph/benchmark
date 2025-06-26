package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CampaignManagerTest {
  @Test
  void launchCampaign() {
    var instance = new CampaignManager();
    assertEquals("Campaign launched: Spring", instance.launchCampaign("Spring"));
  }
}
