package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class NewsletterGenerationJobTest {
    @Test
    void generateSummary() {
        var instance = new NewsletterGenerationJob();
        assertEquals("Newsletter summary generated.", instance.generateSummary());
    }
} 