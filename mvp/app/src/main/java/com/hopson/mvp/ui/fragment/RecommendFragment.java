package com.hopson.mvp.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hopson.mvp.R;
import com.hopson.mvp.data.bean.AppInfo;
import com.hopson.mvp.data.bean.PageBean;
import com.hopson.mvp.data.bean.StatusInfo;
import com.hopson.mvp.http.ApiService;
import com.hopson.mvp.http.HttpManager;
import com.hopson.mvp.presenter.RecommendPresenter;
import com.hopson.mvp.presenter.contract.RecommendContract;
import com.hopson.mvp.ui.adapter.RecommendAppAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendFragment extends Fragment implements RecommendContract.View {

    String TAG = "RecommendFragment";
    RecommendAppAdapter mAdapter;
    @BindView(R.id.recycleview)
    RecyclerView recycleview;


    private RecommendContract.Presenter mPresenter;

    ProgressDialog progressDialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this,view);
        progressDialog = new ProgressDialog(getActivity());
        mPresenter = new RecommendPresenter(this);

        initData();
        return view;
    }


    private void initData() {

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
