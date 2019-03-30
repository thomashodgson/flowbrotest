package com.sample;

import java.lang.String;

public class Unit_bbyq4m_root {
  private final S3Reader s3Reader;

  public Unit_bbyq4m_root(final S3Reader s3Reader) {
    this.s3Reader = s3Reader;
  }

  public String execute(final String bucketName, final String path) {
    final String contents = s3Reader.execute(bucketName, path);
    return contents;
  }
}
