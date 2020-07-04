package com.hopson.mvp;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.hopson.mvp.di.component.AppCompenent;
import com.hopson.mvp.di.component.DaggerAppCompenent;
import com.hopson.mvp.di.module.AppModule;
import com.hopson.mvp.di.module.HttpModule;
import com.umeng.analytics.MobclickAgent;

import javax.inject.Inject;

public class AppAplication  extends Application {

    private AppCompenent mAppCompenent;
    @Inject
    public Gson gson;

    public AppCompenent getAppCompenent() {
        return mAppCompenent;
    }

    public static AppAplication get(Context context){
        return (AppAplication) context.getApplicationContext();
    };

    @Override
    public void onCreate() {
        super.onCreate();

        mAppCompenent = DaggerAppCompenent.builder().appModule(new AppModule(this)).httpModule(new HttpModule()).build();
        initUMeng();
    }
    public void initUMeng(){
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType. E_UM_NORMAL);
        MobclickAgent.openActivityDurationTrack(false);
    }
}
