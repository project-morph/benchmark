package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.getunleash.Unleash;
import org.junit.jupiter.api.Test;

class CampaignManagerTest {
  @Test
  void launchCampaign() {
    var unleashMock = mock(Unleash.class);
    when(unleashMock.isEnabled("campaign-launch-enabled")).thenReturn(true);
    when(unleashMock.isEnabled("campaign-status-check-enabled")).thenReturn(true);
    when(unleashMock.isEnabled("campaign-logging-enabled")).thenReturn(true);
    var instance = new CampaignManager(unleashMock);
    assertEquals("Campaign launched: Spring", instance.launchCampaign("Spring"));
  }
}
