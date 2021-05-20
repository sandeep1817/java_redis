package base;

import commons.RedisConnection;
import exceptions.RedisException;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

  private RedisConnection redisConnection;

  public static void main(String[] args) throws RedisException, InterruptedException {
    Test test = new Test();
    test.redisConnection = new RedisConnection();
    test.redisConnection.setUpTheRedisConnection("localhost");
    test.redisConnection.setOrUpdateTheKeyValue("testing", "key updated successfully", true);
    Thread.sleep(4000);
   System.out.println( test.redisConnection.getTheValueUsingKey("testing"));
  }
}
