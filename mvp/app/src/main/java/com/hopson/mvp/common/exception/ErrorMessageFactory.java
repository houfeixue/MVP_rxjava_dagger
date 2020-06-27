package com.hopson.mvp.common.exception;

import android.content.Context;

public class ErrorMessageFactory {
    public  static  String create(Context context, int code){


        return  "ErrorMessageFactory" + code;


    }
}
