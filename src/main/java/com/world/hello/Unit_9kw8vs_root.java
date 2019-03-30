package com.world.hello;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.world.hello.aws.dynamo.DynamoConfig;
import com.world.hello.aws.dynamo.DynamoItemReader;
import com.world.hello.aws.s3.S3Config;
import com.world.hello.aws.s3.S3FileWriter;
import com.world.hello.config.Config;
import com.world.hello.config.ConfigProvider;
import java.lang.String;

public class Unit_9kw8vs_root {
  private final ConfigProvider configProvider;

  private final Unit_9kw8vs_root_1 unit_9kw8vs_root_1;

  private final Unit_9kw8vs_root_2 unit_9kw8vs_root_2;

  private final DynamoItemReader dynamoReader;

  private final Unit_9kw8vs_root_4 unit_9kw8vs_root_4;

  private final Unit_9kw8vs_root_5 unit_9kw8vs_root_5;

  private final S3FileWriter s3Writer;

  public Unit_9kw8vs_root(final ConfigProvider configProvider,
      final Unit_9kw8vs_root_1 unit_9kw8vs_root_1, final Unit_9kw8vs_root_2 unit_9kw8vs_root_2,
      final DynamoItemReader dynamoReader, final Unit_9kw8vs_root_4 unit_9kw8vs_root_4,
      final Unit_9kw8vs_root_5 unit_9kw8vs_root_5, final S3FileWriter s3Writer) {
    this.configProvider = configProvider;
    this.unit_9kw8vs_root_1 = unit_9kw8vs_root_1;
    this.unit_9kw8vs_root_2 = unit_9kw8vs_root_2;
    this.dynamoReader = dynamoReader;
    this.unit_9kw8vs_root_4 = unit_9kw8vs_root_4;
    this.unit_9kw8vs_root_5 = unit_9kw8vs_root_5;
    this.s3Writer = s3Writer;
  }

  public void execute() {
    final Config config = configProvider.execute();
    final DynamoConfig dynamoConfig = unit_9kw8vs_root_1.execute(config);
    final String string = unit_9kw8vs_root_2.execute(config);
    final Item item = dynamoReader.execute(dynamoConfig, string);
    final String string = unit_9kw8vs_root_4.execute(item);
    final S3Config s3Config = unit_9kw8vs_root_5.execute(config);
    s3Writer.execute(s3Config, string);
  }
}
