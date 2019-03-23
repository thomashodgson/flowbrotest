package com.aPackage.app;

import java.lang.String;

public class DynamoToS3Copier {
  private final DynamoExporter dynamoExporter;

  private final S3Importer s3Importer;

  public DynamoToS3Copier(final DynamoExporter dynamoExporter, final S3Importer s3Importer) {
    this.dynamoExporter = dynamoExporter;
    this.s3Importer = s3Importer;
  }

  public void execute(final String id) {
    this.dynamoExporter.execute(id);
    this.s3Importer.execute(id);
  }
}
