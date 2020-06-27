package com.hopson.mvp.presenter.contract;

import com.hopson.mvp.data.bean.AppInfo;
import com.hopson.mvp.presenter.BasePresenter;
import com.hopson.mvp.ui.BaseView;

import java.util.List;

public interface RecommendContract {

    interface  View extends BaseView {

        void showNoData();
        void showError(String msg);
        void showResult(List<AppInfo> lists);
        void showBanner(List<AppInfo> lists);

    }

}
