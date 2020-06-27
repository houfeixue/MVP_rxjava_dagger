package com.hopson.mvp.common.rx.observer;

import android.content.Context;
import android.widget.Toast;

import com.hopson.mvp.common.exception.ApiExceptiom;
import com.hopson.mvp.common.exception.BaseException;
import com.hopson.mvp.common.exception.ErrorMessageFactory;

import org.json.JSONException;

import java.net.SocketException;

import retrofit2.HttpException;

public class RXErrorHandler {

    private Context mContext;

    public RXErrorHandler(Context mContext) {
        this.mContext = mContext;
    }

    public BaseException handlerError(Throwable e){
        BaseException exception = new BaseException();

        if (e instanceof ApiExceptiom){

            exception .setCode(((ApiExceptiom)e).getCode());

        }else if(e instanceof SocketException){
            exception .setCode(BaseException.SOCKET_ERROR);

        }else if( e instanceof HttpException){
            exception .setCode(((HttpException)e).code());

        }else if( e instanceof JSONException){
            exception .setCode(BaseException.JSON_ERROR);

        }else {
            exception .setCode(BaseException.UNKNOWN_ERROR);

        }
        exception.setMsg(ErrorMessageFactory.create(mContext,exception.getCode()));
        return  exception;
    }

    public void  showErrorMessage(BaseException e){
        Toast.makeText(mContext,e.getMsg(),Toast.LENGTH_LONG).show();
    }
}
