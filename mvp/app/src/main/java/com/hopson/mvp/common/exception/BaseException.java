package com.hopson.mvp.common.exception;

public class BaseException extends Exception{


    //    API错误
    public static final int API_ERROR = 0x0;

    //    网络错误
    public static final int NETWORK_ERROR = 0x1;
    //    http错误
    public static final int HTTP_ERROR = 0x2;
    //    json错误
    public static final int JSON_ERROR = 0x3;

    //    未知错误
    public static final int UNKNOWN_ERROR = 0x4;

    //   运行错误错误
    public static final int RUN_ERROR = 0x5;

    //   域名错误错误
    public static final int UNKNOWNHOST_ERROR = 0x6;
    //   链接超时错误
    public static final int SOCKET_TIME_ERROR = 0x7;
    //   无网络链接错误
    public static final int SOCKET_ERROR = 0x8;

    //服务器错误
    public static final int ERROE_API_SYSTEM = 10000;

    //登录错误错误
    public static final int ERROE_API_LOGIN = 10002;

    //无权限错误
    public static final int ERROE_API_NO_PERMISSION = 10003;

    //http
    public static final int ERROE_HTTP_400 = 400;
    public static final int ERROE_HTTP_404 = 404;
    public static final int ERROE_HTTP_405 = 4055;


    private int code;
    private String msg;
    public BaseException(){

    }

    public BaseException(int code,String msg){
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
