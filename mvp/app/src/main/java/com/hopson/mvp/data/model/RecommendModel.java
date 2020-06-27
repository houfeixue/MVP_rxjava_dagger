package com.hopson.mvp.data.model;

import com.hopson.mvp.data.bean.AppInfo;
import com.hopson.mvp.data.bean.PageBean;
import com.hopson.mvp.data.bean.StatusInfo;
import com.hopson.mvp.data.http.ApiService;

import io.reactivex.Observable;
import retrofit2.Callback;

public class RecommendModel {
    private String TAG = "RecommendModel";

    private ApiService apiService;

    public RecommendModel(ApiService apiService) {
        this.apiService = apiService;
    }

//    public void getApps(Callback<StatusInfo<PageBean<AppInfo>>> callback){
////        HttpManager manager = new HttpManager();
////        ApiService apiService = manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);
//        this.apiService.getApps("c2f763919989e7794508edb82375bfbf").enqueue(callback);
//    }

    public Observable<StatusInfo<PageBean<AppInfo>>> getApps(){
//        HttpManager manager = new HttpManager();
//        ApiService apiService = manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);
       return  this.apiService.getApps("c2f763919989e7794508edb82375bfbf");
    }


    public Observable<StatusInfo<PageBean<AppInfo>>> getBanner(){
//        HttpManager manager = new HttpManager();
//        ApiService apiService = manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);
        return  this.apiService.getBanner("c2f763919989e7794508edb82375bfbf");
    }



}

