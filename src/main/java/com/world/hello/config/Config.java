package com.world.hello.config;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class Config {
  public final String someString;

  public Config(final String someString) {
    this.someString = someString;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Config config = (Config) o;
    return Objects.equals(someString, config.someString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(someString);
  }

  @Override
  public String toString() {
    return "Config{" + 
         "someString = " + someString +
         "}";
  }
}
