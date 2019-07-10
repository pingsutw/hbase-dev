package com.hbase.app;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.AsyncConnection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public class AsyncOperations {
  AsyncConnection asyncConnection;
  public void run(Configuration config) throws IOException {
      ConnectionFactory.createAsyncConnection(config)
       .whenComplete((con,ex) -> {
         if(ex == null)
           asyncConnection = con;
         else
           ex.printStackTrace();
    }).join();
  }
}
