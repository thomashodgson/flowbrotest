package com.world.hello.aws.dynamo;

import com.amazonaws.services.dynamodbv2.document.Item;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DynamoItemReaderTest {

    // Values
    private final static String tableName;
    private final static String idFieldName;
    private final static String region;
    private final static DynamoConfig dynamoConfig;
    private final static String recordId;
    private final static Item expectedItem;

    static {
        tableName = "aTableName";
        idFieldName = "id";
        region = "aRegion";
        dynamoConfig = new DynamoConfig(region, tableName, idFieldName);
        recordId = "aRecordId";
        expectedItem = new Item().withString(idFieldName, recordId).withString("name", "a record name");
    }

    // Resources
    private static LocalDynamoDbProvider localDynamoDbProvider;

    @BeforeAll
    static void setupResources() {
        localDynamoDbProvider = LocalDynamoDbProvider.create(tableName, idFieldName, Arrays.asList(
                new Item().withString(idFieldName, "record-0").withString("name", "record 0"),
                expectedItem,
                new Item().withString(idFieldName, "record-2").withString("name", "record 2")
        ));
    }

    @AfterAll
    static void tearDownResources() {
        localDynamoDbProvider.dynamoDB.shutdown();
    }

    // Mocked dependencies
    private DynamoClientProvider dynamoClientProvider;

    // Test Fixture
    private DynamoItemReader dynamoRecordById;

    @BeforeEach
    void setupTestFixture() {
        dynamoClientProvider = mock(DynamoClientProvider.class);
        dynamoRecordById = new DynamoItemReader(dynamoClientProvider);
    }

    @Test
    void test1() {
        when(dynamoClientProvider.get(region)).thenReturn(localDynamoDbProvider.dynamoDB);

        assertEquals(
                dynamoRecordById.execute(dynamoConfig, recordId),
                expectedItem,
                "Get record by id should return the correct item"
        );
    }
}