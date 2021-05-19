package commons;

import enums.RedisExceptionEnums;
import exceptions.RedisException;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

@Slf4j
public class RedisConnection {
  private Jedis jedis;

  public void setUpTheRedisConnection(final String serverIpConnect) {
    jedis = new Jedis(serverIpConnect);
  }

  public void setOrUpdateTheKeyValue(
      final String key, final String value, final boolean isOverride) {
    try {
      if (jedis.exists(key) && !isOverride) {
        log.info(
            "As value for key {} already exists not updating, value existing is {} ",
            key,
            jedis.get(key));
        return;
      } else {
        jedis.set(key, value);
        log.info("successfully updated value for key {}", key);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getTheValueUsingKey(final String key) throws RedisException {
    try {
      return jedis.get(key);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RedisException(RedisExceptionEnums.REDIS_SERVER_EXCEPTION);
    }
  }
}
