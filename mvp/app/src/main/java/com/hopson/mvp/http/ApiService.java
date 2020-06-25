package com.hopson.mvp.http;

import com.hopson.mvp.data.bean.AppInfo;
import com.hopson.mvp.data.bean.PageBean;
import com.hopson.mvp.data.bean.StatusInfo;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    static String BASE_URL = "https://www.pgyer.com/";
    static String BASE_IMAGE_URL = "http://appicon.pgyer.com/image/view/app_icons/";

    @POST("/apiv2/app/listMy/")
    public Call<StatusInfo<PageBean<AppInfo>>> getApps(@Query("_api_key") String json);


}
