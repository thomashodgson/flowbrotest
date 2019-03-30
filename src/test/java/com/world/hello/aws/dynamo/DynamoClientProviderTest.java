package com.world.hello.aws.dynamo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DynamoClientProviderTest {

    private final static String region1;
    private final static String region2;

    static {
        region1 = "eu-west-1";
        region2 = "eu-west-2";
    }

    //@Test // - runs against live AWS Dynamo
    void test1() {
        assertEquals(
                new DynamoClientProvider()
                        .get(region1)
                        .listTables(1).getTableNames().size(),
                1,
                "Can connect to AWS Dynamo DB");
    }

    @Test
    void test2() {
        assertNotEquals(
                new DynamoClientProvider()
                        .get(region1),
                new DynamoClientProvider()
                        .get(region2),
                "should create a new client for each region");
    }

    @Test
    void test3() {
        assertEquals(
                new DynamoClientProvider()
                        .get(region1),
                new DynamoClientProvider()
                        .get(region1),
                "should cache clients by region");
    }
}