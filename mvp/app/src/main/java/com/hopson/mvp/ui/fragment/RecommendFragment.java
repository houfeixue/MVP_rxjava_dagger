package com.hopson.mvp.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
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

public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendContract.View {

    String TAG = "RecommendFragment";
    RecommendAppAdapter mAdapter;
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
    }

    @Override
    public void setupActivityCommponent(AppCompenent appCompenent) {
        DaggerRecommendComponent.builder().appCompenent(appCompenent).recommendModule(new RecommendModule(this,getActivity())).build().inject(this);
        mPresenter.requestDatas();

    }

    private void initRecycleView(List<AppInfo> appInfos) {

        //设置管理布局
        recycleview.setLayoutManager(new LinearLayoutManager(getActivity()));

        //设置分割线
        recycleview.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));
        //动画
        recycleview.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new RecommendAppAdapter(getActivity(), appInfos);
        recycleview.setAdapter(mAdapter);


    }

    @Override
    public void showNoData() {
        Toast.makeText(getActivity(),"暂时无数据",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(),"服务器开小差了" + msg,Toast.LENGTH_LONG).show();

    }

    @Override
    public void showResult(List<AppInfo> lists) {
        initRecycleView(lists);

    }

    @Override
    public void showLoading() {
        progressDialog.show();

    }

    @Override
    public void dismissLoading() {
        if (progressDialog.isShowing()){
            progressDialog.hide();

        }

    }
}
