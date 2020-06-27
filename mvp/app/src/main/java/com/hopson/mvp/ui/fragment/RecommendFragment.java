package com.hopson.mvp.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hopson.mvp.AppAplication;
import com.hopson.mvp.R;
import com.hopson.mvp.data.bean.AppInfo;
import com.hopson.mvp.di.component.AppCompenent;
import com.hopson.mvp.di.component.DaggerRecommendComponent;
import com.hopson.mvp.di.module.RecommendModule;
import com.hopson.mvp.presenter.RecommendPresenter;
import com.hopson.mvp.presenter.contract.RecommendContract;
import com.hopson.mvp.ui.adapter.IndexMutilAdapter;
import com.hopson.mvp.ui.adapter.RecommendAppAdapter;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendFragment extends ProgressFragment<RecommendPresenter> implements RecommendContract.View {

    String TAG = "RecommendFragment";
//    RecommendAppAdapter mAdapter;
    IndexMutilAdapter mAdapter;
    @BindView(R.id.recycleview)
    RecyclerView recycleview;


    @Inject
    ProgressDialog progressDialog;

    @Override
    public int setLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void init() {
        initRecycleView();
    }

    @Override
    public void setupActivityCommponent(AppCompenent appCompenent) {
        DaggerRecommendComponent.builder().appCompenent(appCompenent).recommendModule(new RecommendModule(this,getActivity())).build().inject(this);
        mPresenter.requestDatas();

    }

    private void initRecycleView() {

        //设置管理布局
        recycleview.setLayoutManager(new LinearLayoutManager(getActivity()));

        //设置分割线
//        recycleview.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));
        //动画
        recycleview.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new IndexMutilAdapter(getActivity());
        recycleview.setAdapter(mAdapter);


    }

    @Override
    public void showNoData() {
        showEmptyView("暂时无数据");

        Toast.makeText(getActivity(),"暂时无数据",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(),"服务器开小差了" + msg,Toast.LENGTH_LONG).show();

    }

    @Override
    public void showResult(List<AppInfo> lists) {
        showContentView();

    }

    @Override
    public void showBanner(List<AppInfo> lists) {
        showContentView();

        Log.e("recommend" , lists.toString());
        mAdapter.setData(lists);


    }

    @Override
    public void showLoading() {
//        progressDialog.show();
        showProgressView();
    }


    @Override
    public void dismissLoading() {
        if (progressDialog.isShowing()){
            progressDialog.hide();

        }

    }

    @Override
    public void onRequestPermissionSucess() {
        Toast.makeText(getActivity(),"IMEI授权成功",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onRequestPermissionError() {
        Toast.makeText(getActivity(),"IMEI授权失败",Toast.LENGTH_LONG).show();

    }
}
