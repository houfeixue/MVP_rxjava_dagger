package com.hopson.mvp.presenter;

import android.Manifest;
import android.app.Activity;
import android.widget.Toast;

import com.hopson.mvp.common.rx.RxHttpResponseCompat;
import com.hopson.mvp.common.rx.observer.ErrorHandleObserver;
import com.hopson.mvp.common.rx.observer.RXErrorHandler;
import com.hopson.mvp.common.utils.DeviceUtils;
import com.hopson.mvp.data.bean.AppInfo;
import com.hopson.mvp.data.bean.BaseData;
import com.hopson.mvp.data.bean.PageBean;
import com.hopson.mvp.data.bean.StatusInfo;
import com.hopson.mvp.data.model.RecommendModel;
import com.hopson.mvp.presenter.contract.RecommendContract;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.List;

import javax.inject.Inject;


import androidx.fragment.app.FragmentActivity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RecommendPresenter extends BasePresenter<RecommendModel,RecommendContract.View> {

    private RXErrorHandler mRXErrorHandler;
    @Inject
    public RecommendPresenter(RecommendContract.View mView, RecommendModel mModel, RXErrorHandler rxErrorHandler) {
        super(mView, mModel);
        initContext();
        this.mRXErrorHandler = rxErrorHandler;
    }

    public void requestPermission(){

        RxPermissions rxPermissions = new RxPermissions((FragmentActivity) mContext);

        rxPermissions
                .request(Manifest.permission.READ_PHONE_STATE)
                .subscribe(granted -> {
                    if (granted) { // Always true pre-M
//                        // I can control the camera now
//                        String imei =  DeviceUtils.getIMEI(mContext);
//                        Toast.makeText(mContext,imei,Toast.LENGTH_LONG).show();
                        mView.onRequestPermissionSucess();
                    } else {
                        // Oups permission denied
                        mView.onRequestPermissionError();

//                        Toast.makeText(mContext,"IMEI授权失败",Toast.LENGTH_LONG).show();
                    }
                });
    }


    public void requestDatas() {
        mView.showLoading();

        mModel.getApps().compose(RxHttpResponseCompat.<PageBean<AppInfo>>compatResult())
                .subscribe(new ErrorHandleObserver<PageBean<AppInfo>>(mRXErrorHandler){
                    @Override
                    public void onNext(PageBean<AppInfo> appInfoPageBean) {
                        super.onNext(appInfoPageBean);
                        mView.showResult((List<AppInfo>) appInfoPageBean.getList());
//                        mView.showError("网络连接失败");
//                        mView.showNoData();

                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        mView.dismissLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.dismissLoading();
                        mView.showError(e.getMessage());

                    }
                });

//        mModel.getApps()
//                .compose(RxHttpResponseCompat.<PageBean<AppInfo>>compatResult())
//                .subscribe(new Observer<PageBean<AppInfo>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                    }
//                    @Override
//                    public void onNext(PageBean<AppInfo> pageBeanStatusInfo) {
//                      mView.showResult((List<AppInfo>) pageBeanStatusInfo.getList());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        mView.dismissLoading();
//
//                    }
//                });



//        mModel.getApps(new Callback<StatusInfo<PageBean<AppInfo>>>() {
//            @Override
//            public void onResponse(Call<StatusInfo<PageBean<AppInfo>>> call, Response<StatusInfo<PageBean<AppInfo>>> response) {
//                //业务处理
//                if (response != null){
//                    mView.showResult((List<AppInfo>) response.body().getData().getList());
//                }else {
//                    mView.showNoData();
//                }
//                mView.dismissLoading();
//            }
//
//            @Override
//            public void onFailure(Call<StatusInfo<PageBean<AppInfo>>> call, Throwable t) {
//                mView.dismissLoading();
//                mView.showError(t.getMessage());
//            }
//        });

    }
}
