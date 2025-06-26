package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class CampaignManagerTest {
  @Test
  void launchCampaign() {
    Unleash unleash = mock(Unleash.class);
    when(unleash.isEnabled("campaign-launch-enabled")).thenReturn(true);
    when(unleash.isEnabled("campaign-status-check-enabled")).thenReturn(true);
    when(unleash.isEnabled("campaign-logging-enabled")).thenReturn(true);
    var instance = new CampaignManager(unleash);
    assertEquals("Campaign launched: Spring", instance.launchCampaign("Spring"));
  }
}
