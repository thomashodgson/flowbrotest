package com.world.hello.config;

import com.typesafe.config.ConfigFactory;
import java.lang.String;

public class ConfigProvider {
  private final EnvironmentProvider environmentProvider;

  public ConfigProvider(final EnvironmentProvider environmentProvider) {
    this.environmentProvider = environmentProvider;
  }

  public Config execute() {
    com.typesafe.config.Config config = ConfigFactory.load();
    final String environment = environmentProvider.execute();
    final String someString = config.getString(String.format("%s.someString", environment));
    return new Config(someString);
  }
}
