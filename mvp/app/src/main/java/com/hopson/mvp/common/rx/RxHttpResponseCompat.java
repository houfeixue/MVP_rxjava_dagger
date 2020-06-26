package com.hopson.mvp.common.rx;

import com.hopson.mvp.common.exception.ApiExceptiom;
import com.hopson.mvp.data.bean.BaseData;
import com.hopson.mvp.data.bean.StatusInfo;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class RxHttpResponseCompat {

    public static   <T> ObservableTransformer<StatusInfo<T>,T> compatResult(){

        return upstream ->{
            return upstream.flatMap(result -> {
                        if (result.sucess()) {
                            return createData(result.getData());
                        }
//                        else if (result.isTokenInvalid()) {
//                            //处理token失效，tokenInvalid方法在BaseActivity 实现
//                            tokenInvalid();
//                        }
                        else {
                            return Observable.error(new ApiExceptiom(result.getCode(),result.getMessage()));
                        }
                    }

            ).subscribeOn(io.reactivex.schedulers.Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        };

    };

    private static <T> Observable<T> createData(final T t) {
        return Observable.create(subscriber -> {
            try {
                subscriber.onNext(t);
                subscriber.onComplete();
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });
    }
}
