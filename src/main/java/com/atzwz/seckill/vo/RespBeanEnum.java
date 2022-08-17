package com.atzwz.seckill.vo;



public enum RespBeanEnum {
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"ERROR"),
    LOGIN_ERROR(50010,"用户名和密码错误"),
    MOBILE_ERROR(50011,"手机号码格式不正确"),
    BIND_ERROP(50012,"参数校验异常"),
    EMPTY_ERROR(50050,"空库存"),
    REPEATE_ERROE(50051,"该商品每人限购一件");
    private final Integer code;
    private final String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "RespBeanEnum{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    RespBeanEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
