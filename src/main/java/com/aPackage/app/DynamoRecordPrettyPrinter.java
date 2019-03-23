package com.aPackage.app;

import java.lang.String;

public class DynamoRecordPrettyPrinter {
  public String execute(final Item item) {

        return item.toJSONPretty()    
  }
}
