package com.hopson.mvp.common.rx.observer;

import android.app.ProgressDialog;
import android.content.Context;

import io.reactivex.disposables.Disposable;

public class ProgressDialogObserver<T>  extends ErrorHandleObserver<T>{

    private Context context;
    ProgressDialog progressDialog;

    public ProgressDialogObserver(Context context,RXErrorHandler rxErrorHandler) {
        super(rxErrorHandler);
        this.context = context;
    }

    @Override
    public void onSubscribe(Disposable d) {
        super.onSubscribe(d);
        d.dispose();
    }

    @Override
    public void onNext(T t) {
        super.onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
    }

    @Override
    public void onComplete() {
        super.onComplete();
    }


    private void initProgressDialog(){
         progressDialog = new ProgressDialog(this.context);
    }

    private void showProgressDialog(){

    }

    private void dismissProgressDialog(){

    }

}
