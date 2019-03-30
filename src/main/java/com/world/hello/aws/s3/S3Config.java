package com.world.hello.aws.s3;

import java.util.Objects;

public class S3Config {
    public final String bucketName;
    public final String path;

    public S3Config(final String bucketName, final String path) {
        this.bucketName = bucketName;
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        S3Config s3Config = (S3Config) o;
        return bucketName.equals(s3Config.bucketName) &&
                path.equals(s3Config.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bucketName, path);
    }

    @Override
    public String toString() {
        return "S3Config{" +
                "bucketName='" + bucketName + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
