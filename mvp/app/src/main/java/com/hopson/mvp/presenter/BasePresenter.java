package com.hopson.mvp.presenter;

import android.app.Activity;
import android.content.Context;

import com.hopson.mvp.data.model.RecommendModel;
import com.hopson.mvp.presenter.contract.RecommendContract;
import com.hopson.mvp.ui.BaseView;

import androidx.fragment.app.Fragment;

public class BasePresenter <M,V extends BaseView> {

    protected V mView;
    protected M mModel;
    protected Context mContext;

    public BasePresenter(V mView, M mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }

    private void  initContext(){
        if (mView instanceof Fragment){
            mContext = ((Fragment)mView).getActivity();
        }else {
            mContext = (Activity) mView;
        }
    }
}
