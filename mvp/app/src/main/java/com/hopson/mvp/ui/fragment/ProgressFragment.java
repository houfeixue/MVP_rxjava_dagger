package com.hopson.mvp.ui.fragment;

import android.os.Binder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

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

public abstract class ProgressFragment<T extends BasePresenter> extends Fragment {

    private FrameLayout rootView;

    private View mViewProgress;
    private FrameLayout mViewContent;
    private View mViewEmpty;
    private TextView mTiptextView;


    private Unbinder unbinder;
    private AppAplication appAplication;

    @Inject
    T mPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (FrameLayout)inflater.inflate(R.layout.fragment_progress,container,false);

        mViewProgress = rootView.findViewById(R.id.view_progress);
        mViewContent = rootView.findViewById(R.id.view_content);
        mViewEmpty = rootView.findViewById(R.id.view_empty);
        mViewEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mTiptextView = (TextView) rootView.findViewById(R.id.text_tip);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setRealContentView();
        appAplication = (AppAplication)getActivity().getApplication();
        setupActivityCommponent(appAplication.getAppCompenent());
        init();
    }

    private   void setRealContentView(){
       View contentView = LayoutInflater.from(getActivity()).inflate(setLayout(),mViewContent,true);
       unbinder = ButterKnife.bind(this,contentView);


    };

    public abstract int setLayout();
    public abstract void setupActivityCommponent(AppCompenent appCompenent);
    public abstract void init();

    //空页面的点击方法
    public void onEmptyClick(){
    }

    public void showProgressView(){
        showView(R.id.view_progress);
    }
    public void showContentView(){
        showView(R.id.view_content);

    }

    public void showEmptyView(){
        showView(R.id.view_empty);

    }
    public void showEmptyView(int resId){
        showEmptyView();
        mTiptextView.setText(resId);

    }
    public void showEmptyView(String msg){
        showEmptyView();
        mTiptextView.setText(msg);

    }

    public void showView(int viewId){
        for (int i = 0 ; i< rootView.getChildCount() ; i++){
            if (rootView.getChildAt(i).getId() == viewId){
                rootView.getChildAt(i).setVisibility(View.VISIBLE);
            }else {
                rootView.getChildAt(i).setVisibility(View.GONE);

            }
        }

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != Unbinder.EMPTY){
            unbinder.unbind();
        }
    }
}
