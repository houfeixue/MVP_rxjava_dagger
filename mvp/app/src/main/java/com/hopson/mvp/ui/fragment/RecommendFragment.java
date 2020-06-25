package com.hopson.mvp.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hopson.mvp.R;
import com.hopson.mvp.data.bean.AppInfo;
import com.hopson.mvp.data.bean.PageBean;
import com.hopson.mvp.data.bean.StatusInfo;
import com.hopson.mvp.http.ApiService;
import com.hopson.mvp.http.HttpManager;
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

public class RecommendFragment extends Fragment {

    String TAG = "RecommendFragment";
    RecommendAppAdapter mAdapter;
    @BindView(R.id.recycleview)
    RecyclerView recycleview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this,view);
        initData();
        return view;
    }


    private void initData() {
        HttpManager manager = new HttpManager();
        ApiService apiService = manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);
        apiService.getApps("c2f763919989e7794508edb82375bfbf").enqueue(new Callback<StatusInfo<PageBean<AppInfo>>>() {
            @Override
            public void onResponse(Call<StatusInfo<PageBean<AppInfo>>> call, Response<StatusInfo<PageBean<AppInfo>>> response) {
                StatusInfo<PageBean<AppInfo>> statusInfo = response.body();

                List<AppInfo> appInfos = (List<AppInfo>) statusInfo.getData().getList();

                Log.e(TAG, "onResponse: " + statusInfo.getCode());
                initRecycleView(appInfos);


            }

            @Override
            public void onFailure(Call<StatusInfo<PageBean<AppInfo>>> call, Throwable t) {
                Log.e(TAG, "onFailure: ");

            }
        });
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

}
