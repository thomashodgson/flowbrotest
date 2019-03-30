package com.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.String;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Unit_gcytgt_root_0Test {
  /**
   * Variables */
  private static final String hello;

  private static final String helloa;

  /**
   * Test fixture */
  private Unit_gcytgt_root_0 unit_gcytgt_root_0;

  static {
    hello = "hello";
    helloa = "hello-a";
  }

  @BeforeEach
  public void setupTestFixture() {

    unit_gcytgt_root_0 = new Unit_gcytgt_root_0();
  }

  @Test
  public void test1() {

    assertEquals(helloa, unit_gcytgt_root_0.execute(hello), "this one should pass");
  }
}
