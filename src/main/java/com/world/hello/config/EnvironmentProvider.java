package com.world.hello.config;

public class EnvironmentProvider {
    public String execute() {
        return System.getProperty("Environment");
    }
}
