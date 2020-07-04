package com.hopson.mvp.ui.activity;

import android.app.Application;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.hopson.mvp.AppAplication;
import com.hopson.mvp.R;
import com.hopson.mvp.di.component.AppCompenent;
import com.hopson.mvp.presenter.BasePresenter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    private String TAG;
    private Unbinder mUnbinder;
    private AppAplication mAppAplication;

    T mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TAG = getComponentName().getShortClassName();

        setContentView(setLayout());
        mUnbinder = ButterKnife.bind(this);
        this.mAppAplication = (AppAplication) getApplication();
        setupActivityCommponent(mAppAplication.getAppCompenent());
        init();
    }



    public abstract int setLayout();

    public abstract void setupActivityCommponent(AppCompenent appCompenent);

    public abstract void init();

    @Override
    protected void onDestroy() {

        super.onDestroy();
        if (mUnbinder != Unbinder.EMPTY){
            mUnbinder.unbind();
        }
    }
}
