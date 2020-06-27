package com.hopson.mvp.common.rx.observer;

import com.hopson.mvp.common.exception.ApiExceptiom;
import com.hopson.mvp.common.exception.BaseException;
import com.hopson.mvp.common.exception.ErrorMessageFactory;

import org.json.JSONException;

import java.net.SocketException;

import retrofit2.HttpException;

public class ErrorHandleObserver<T> extends BaseObserver<T> {

   private   RXErrorHandler rxErrorHandler;

    public ErrorHandleObserver(RXErrorHandler rxErrorHandler) {
        this.rxErrorHandler = rxErrorHandler;
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);

        BaseException baseException = rxErrorHandler.handlerError(e);

        rxErrorHandler.showErrorMessage(baseException);

    }
}
