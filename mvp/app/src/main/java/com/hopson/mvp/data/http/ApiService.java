package com.hopson.mvp.data.http;

import com.hopson.mvp.data.bean.AppInfo;
import com.hopson.mvp.data.bean.PageBean;
import com.hopson.mvp.data.bean.StatusInfo;
import com.hopson.mvp.data.bean.requestBean.LoginRequestBean;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    static String BASE_URL = "https://www.pgyer.com/";
    static String BASE_IMAGE_URL = "http://appicon.pgyer.com/image/view/app_icons/";

    @POST("/apiv2/app/listMy/")
    public Observable<StatusInfo<PageBean<AppInfo>>> getApps(@Query("_api_key") String json);


    @POST("/apiv2/app/listMy/")
    public Observable<StatusInfo<PageBean<AppInfo>>> getBanner(@Query("_api_key") String json);



}
