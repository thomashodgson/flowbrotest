package com.world.hello.aws.dynamo;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;

public class DynamoItemReader {

    private final DynamoClientProvider dynamoClientProvider;

    public DynamoItemReader(final DynamoClientProvider dynamoClientProvider) {
        this.dynamoClientProvider = dynamoClientProvider;
    }

    public Item execute(final DynamoConfig dynamoConfig, final String id) {
        return new DynamoDB(dynamoClientProvider.get(dynamoConfig.region))
                .getTable(dynamoConfig.tableName)
                .getItem(dynamoConfig.idFieldName, id);
    }
}
