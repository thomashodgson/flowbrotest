package com.sample;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.sample.aws.dynamo.DynamoConfig;
import com.sample.aws.dynamo.DynamoItemReader;
import java.lang.String;

public class Unit_b35ul_root {
  private final DynamoItemReader dynamoReader;

  public Unit_b35ul_root(final DynamoItemReader dynamoReader) {
    this.dynamoReader = dynamoReader;
  }

  public Item execute(final DynamoConfig dynamoConfig, final String id) {
    final Item item = dynamoReader.execute(dynamoConfig, id);
    return item;
  }
}
