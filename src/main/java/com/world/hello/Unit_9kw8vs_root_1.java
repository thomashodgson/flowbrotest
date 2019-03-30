package com.world.hello;

import com.world.hello.aws.dynamo.DynamoConfig;
import com.world.hello.config.Config;

public class Unit_9kw8vs_root_1 {
  public DynamoConfig execute(final Config config) {

       return new DynamoConfig(
           config.someString,
           config.someString,
           config.someString
           ); 
        }
}
