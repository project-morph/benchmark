package dev.codemorph.benchmark;

import io.getunleash.Unleash;
import io.getunleash.FakeUnleash;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TestUnleashConfiguration {

    @Bean
    @Primary
    public Unleash unleash() {
        FakeUnleash fakeUnleash = new FakeUnleash();
        fakeUnleash.enableAll();
        return fakeUnleash;
    }
}