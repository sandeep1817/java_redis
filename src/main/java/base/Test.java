package base;

import commons.RedisConnection;
import exceptions.RedisException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {

  private RedisConnection redisConnection;

  public static void main(String[] args) throws RedisException {
    Test test = new Test();
    test.redisConnection = new RedisConnection();
    test.redisConnection.setUpTheRedisConnection("localhost");
    test.redisConnection.setOrUpdateTheKeyValue("testing", "key updated successfully", true);
   System.out.println( test.redisConnection.getTheValueUsingKey("testing"));
  }
}
