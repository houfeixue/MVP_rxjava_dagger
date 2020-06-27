package com.hopson.mvp.ui;

public interface BaseView {
    void showLoading();
    void showError(String msg);
    void  dismissLoading();
}
