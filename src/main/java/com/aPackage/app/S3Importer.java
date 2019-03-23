package com.aPackage.app;

import java.lang.String;

public class S3Importer {
  private final AwsConfigProvider awsConfigProvider;

  private final S3ConfigCreator s3ConfigCreator;

  private final S3Writer s3Writer;

  public S3Importer(final AwsConfigProvider awsConfigProvider,
      final S3ConfigCreator s3ConfigCreator, final S3Writer s3Writer) {
    this.awsConfigProvider = awsConfigProvider;
    this.s3ConfigCreator = s3ConfigCreator;
    this.s3Writer = s3Writer;
  }

  public void execute(final String content) {
    final Config config = this.awsConfigProvider.execute();
    final S3Config s3Config = this.s3ConfigCreator.execute(config);
    this.s3Writer.execute(s3Config, content);
  }
}
