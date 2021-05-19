package exceptions;

import enums.RedisExceptionEnums;
import lombok.Getter;

@Getter
public class RedisException extends Exception {
  private Integer code;
  private String message;

  public RedisException(RedisExceptionEnums redisExceptionEnums) {
    this.code = redisExceptionEnums.getCode();
    this.message = redisExceptionEnums.getMessage();
  }
}
