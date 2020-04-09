package com.zking.zzcloud.common.util;

/**
 * API 统一返回状态码
 */
public enum ResultCode {
    /* 成功状态码，0 表示成功，非0的值表示失败 */
    SUCCESS(0, "Request is successful"),
    FAIL(1, "Request is failed"),
    TOKEN_INVALID(40001, "Token is null or invalid"),
    ACCESS_DENIED(40003, "Access denied"),
    FAIL4DELETE(50001, "Delete failed"),
    FAIL4UPDATE(50002, "Update failed");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
