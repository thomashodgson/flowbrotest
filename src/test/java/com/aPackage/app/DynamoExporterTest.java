package com.aPackage.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.String;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamoExporterTest {
  /**
   * Variables */
  private final String id;

  private final Config config;

  private final Item item;

  private final String out;

  /**
   * Mocked dependencies */
  private AwsConfigProvider awsConfigProvider;

  private DynamoReader dynamoReader;

  /**
   * Test fixture */
  private DynamoExporter dynamoExporter;

  {
    id = "a-record-id";
    final String region = "eu-west-2";
    config = new Config(region, "my.bucket", "directory/path.json", "dynamo-table");
    item = new Item().withString("name", "tom");
    out = "{\"name\":\"tom\"}";
  }

  @BeforeEach
  public void setupTestFixture() {
    awsConfigProvider = mock(AwsConfigProvider.class);
    dynamoReader = mock(DynamoReader.class);

    dynamoExporter = new DynamoExporter(awsConfigProvider, new DynamoConfigCreator(), dynamoReader, new DynamoRecordPrettyPrinter());
  }

  @Test
  public void test1() {
    when(awsConfigProvider.get()).thenReturn(config);
    when(dynamoReader.get(config, id)).thenReturn(item);

    assertEquals(out, dynamoExporter.execute(id), "should encode the item that dynamo returns as json");
  }
}
