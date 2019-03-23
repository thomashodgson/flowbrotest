package com.aPackage.app;

public class S3ConfigCreator {
  public S3Config execute(final Config config) {

        return new S3Config(
            config.region, 
            config.s3Bucket,
            config.s3Path
        ) 
  }
}
