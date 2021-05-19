package enums;

import lombok.Getter;

@Getter
public enum RedisExceptionEnums {

  REDIS_SERVER_EXCEPTION(500, "Redis Server Exception");

  private String message;
  private Integer code;

  RedisExceptionEnums(Integer i, String s) {
    this.code = i;
    this.message = s;
  }
}
