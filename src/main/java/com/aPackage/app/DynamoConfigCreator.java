package com.aPackage.app;

public class DynamoConfigCreator {
  public DynamoConfig execute(final Config config) {

        return new DynamoConfig(
            config.region,
            config.dynamoTable
        )    
  }
}
