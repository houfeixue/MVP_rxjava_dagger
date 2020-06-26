package com.hopson.mvp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hopson.mvp.AppAplication;
import com.hopson.mvp.R;
import com.hopson.mvp.di.component.AppCompenent;
import com.hopson.mvp.presenter.BasePresenter;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    private Unbinder unbinder;
    private AppAplication appAplication;
    private View mRootView;

    @Inject
    T mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(setLayout(), container, false);
        unbinder = ButterKnife.bind(this,mRootView);
        init();
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        appAplication = (AppAplication)getActivity().getApplication();
        setupActivityCommponent(appAplication.getAppCompenent());

    }

    public abstract int setLayout();

    public abstract void setupActivityCommponent(AppCompenent appCompenent);

    public abstract void init();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != Unbinder.EMPTY){
            unbinder.unbind();
        }
    }
}
