package com.hopson.mvp.data.model;

import android.util.Log;

import com.hopson.mvp.data.bean.AppInfo;
import com.hopson.mvp.data.bean.PageBean;
import com.hopson.mvp.data.bean.StatusInfo;
import com.hopson.mvp.http.ApiService;
import com.hopson.mvp.http.HttpManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendModel {
    private String TAG = "RecommendModel";

    public void getApps(Callback<StatusInfo<PageBean<AppInfo>>> callback){
        HttpManager manager = new HttpManager();
        ApiService apiService = manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);
        apiService.getApps("c2f763919989e7794508edb82375bfbf").enqueue(callback);
    }

}

