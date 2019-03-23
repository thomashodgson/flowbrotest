package com.aPackage.app;

import java.lang.String;

public class DynamoExporter {
  private final AwsConfigProvider awsConfigProvider;

  private final DynamoConfigCreator dynamoConfigCreator;

  private final DynamoReader dynamoReader;

  private final DynamoRecordPrettyPrinter dynamoRecordPrettyPrinter;

  public DynamoExporter(final AwsConfigProvider awsConfigProvider,
      final DynamoConfigCreator dynamoConfigCreator, final DynamoReader dynamoReader,
      final DynamoRecordPrettyPrinter dynamoRecordPrettyPrinter) {
    this.awsConfigProvider = awsConfigProvider;
    this.dynamoConfigCreator = dynamoConfigCreator;
    this.dynamoReader = dynamoReader;
    this.dynamoRecordPrettyPrinter = dynamoRecordPrettyPrinter;
  }

  public String execute(final String id) {
    final Config config = this.awsConfigProvider.execute();
    final DynamoConfig dynamoConfig = this.dynamoConfigCreator.execute(config);
    final Item item = this.dynamoReader.execute(dynamoConfig, id);
    final String content = this.dynamoRecordPrettyPrinter.execute(item);
    return content;
  }
}
