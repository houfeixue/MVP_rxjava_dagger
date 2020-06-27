package com.hopson.mvp.common.exception;

public class ApiExceptiom extends BaseException {


    public static final int ERROE_HTTP_500 = 500;

    public ApiExceptiom(int code, String msg) {
        super(code, msg);
    }
}
