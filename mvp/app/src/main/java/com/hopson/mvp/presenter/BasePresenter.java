package com.hopson.mvp.presenter;

import com.hopson.mvp.data.model.RecommendModel;
import com.hopson.mvp.presenter.contract.RecommendContract;
import com.hopson.mvp.ui.BaseView;

public class BasePresenter <M,V extends BaseView> {

    protected V mView;
    protected M mModel;

    public BasePresenter(V mView, M mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }
}
