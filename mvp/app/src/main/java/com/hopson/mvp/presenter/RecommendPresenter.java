package com.hopson.mvp.presenter;

import com.hopson.mvp.data.bean.AppInfo;
import com.hopson.mvp.data.bean.PageBean;
import com.hopson.mvp.data.bean.StatusInfo;
import com.hopson.mvp.data.model.RecommendModel;
import com.hopson.mvp.presenter.contract.RecommendContract;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendPresenter extends BasePresenter<RecommendModel,RecommendContract.View> {

    public RecommendPresenter(RecommendContract.View mView, RecommendModel mModel) {
        super(mView, mModel);
    }

    public void requestDatas() {
        mView.showLoading();
        mModel.getApps(new Callback<StatusInfo<PageBean<AppInfo>>>() {
            @Override
            public void onResponse(Call<StatusInfo<PageBean<AppInfo>>> call, Response<StatusInfo<PageBean<AppInfo>>> response) {
                //业务处理
                if (response != null){
                    mView.showResult((List<AppInfo>) response.body().getData().getList());
                }else {
                    mView.showNoData();
                }
                mView.dismissLoading();
            }

            @Override
            public void onFailure(Call<StatusInfo<PageBean<AppInfo>>> call, Throwable t) {
                mView.dismissLoading();
                mView.showError(t.getMessage());
            }
        });

    }
}
