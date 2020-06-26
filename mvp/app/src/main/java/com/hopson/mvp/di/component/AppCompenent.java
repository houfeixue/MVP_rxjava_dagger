package com.hopson.mvp.di.component;

import com.hopson.mvp.data.http.ApiService;
import com.hopson.mvp.di.module.AppModule;
import com.hopson.mvp.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {AppModule.class , HttpModule.class})
public interface AppCompenent {

    public ApiService getApiService();

}
