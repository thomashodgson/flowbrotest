package com.world.hello.aws.s3;

public class S3FileWriter {
    private final S3ClientProvider s3ClientProvider;

    public S3FileWriter(final S3ClientProvider s3ClientProvider) {
        this.s3ClientProvider = s3ClientProvider;
    }

    public void execute(final S3Config s3Config, final String content) {
        s3ClientProvider.get().putObject(s3Config.bucketName, s3Config.path, content);
    }
}
