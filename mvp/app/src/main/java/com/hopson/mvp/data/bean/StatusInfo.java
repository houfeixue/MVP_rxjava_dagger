package com.hopson.mvp.data.bean;

import com.google.gson.Gson;

public class StatusInfo<T> {


    /**
     * code : 0
     * message :
     * data : {}
     */

    private int code;
    private String message;
    private T data;

    public static StatusInfo objectFromData(String str) {

        return new Gson().fromJson(str, StatusInfo.class);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
}
