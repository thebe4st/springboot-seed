package com.zhongyuan.exception;

public enum ResultCodes {
    SUCCESS("000000","调用成功"),
    QUERY_ERROR("100000","查询错误"),
    RPC_ERROR("400000","远程调用错误"),
    SERVICE_ERROR("-1","服务器错误")
            ;

    public final String code;
    public final String msg;

    ResultCodes(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
