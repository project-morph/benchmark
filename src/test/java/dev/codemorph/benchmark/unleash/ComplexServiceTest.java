package dev.codemorph.benchmark.unleash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ComplexServiceTest {
    @Test
    void compute() {
        var instance = new ComplexService();
        assertEquals(6, instance.compute(3, 2));
    }
} 