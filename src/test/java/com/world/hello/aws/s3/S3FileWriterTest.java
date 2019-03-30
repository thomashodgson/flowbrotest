package com.world.hello.aws.s3;

import org.junit.jupiter.api.BeforeEach;

class S3FileWriterTest {

    // Values
    private static S3Config s3Config;
    private static String content;

    {
        s3Config = new S3Config( "", "folder/file.txt");
        content = "some text content";
    }

    // Test Fixture
    private S3FileWriter s3FileWriter;

    @BeforeEach
    void setupTestFixture() {
        s3FileWriter = new S3FileWriter(new S3ClientProvider());
    }

    // @Test - runs against AWS S3
    void test1() {
        s3FileWriter.execute(s3Config, content);
    }
}