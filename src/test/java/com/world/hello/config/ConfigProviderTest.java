package com.world.hello.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConfigProviderTest {
  private static final Config expectedProductionConfig;

  private static final Config expectedStagingConfig;

  private EnvironmentProvider environmentProvider;

  private ConfigProvider configProvider;

  static {
    expectedStagingConfig = new Config("aString1");
    expectedProductionConfig = new Config("aString0");
  }

  @BeforeEach
  void setupTestFixture() {
    environmentProvider = mock(EnvironmentProvider.class);
    configProvider = new ConfigProvider(environmentProvider);
  }

  @Test
  void test1() {
    when(environmentProvider.execute()).thenReturn("staging");
    assertEquals(
            configProvider.execute(),
            expectedStagingConfig,
            "Correct config should be returned for the staging environment"
    );
  }

  @Test
  void test2() {
    when(environmentProvider.execute()).thenReturn("production");
    assertEquals(
            configProvider.execute(),
            expectedProductionConfig,
            "Correct config should be returned for the production environment"
    );
  }
}
