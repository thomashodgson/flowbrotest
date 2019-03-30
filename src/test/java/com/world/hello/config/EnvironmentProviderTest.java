package com.world.hello.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EnvironmentProviderTest {

    // Values
    private static final String environment;

    static {
        environment = "anEnvironment";
    }

    // Test Fixture
    private EnvironmentProvider environmentProvider;

    @BeforeEach
    void setupTestFixture() {
        System.setProperty("Environment", environment);
        environmentProvider = new EnvironmentProvider();
    }

    @Test
    void test1() {
        assertEquals(environment, environmentProvider.execute());
    }
}