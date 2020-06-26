package com.hopson.mvp.data.bean;

import java.io.Serializable;

public class BaseData<T> implements Serializable {

    public static final  int SUCCESS = 200;
    private int code;
    private String message;
    private T data;

    //判断状态
    public boolean sucess(){
        return  code == SUCCESS;
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
