package com.hopson.mvp.di;

import android.app.ProgressDialog;
import android.content.Context;

import com.hopson.mvp.data.model.RecommendModel;
import com.hopson.mvp.presenter.RecommendPresenter;
import com.hopson.mvp.presenter.contract.RecommendContract;
import com.hopson.mvp.ui.adapter.RecommendAppAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class RecommendModule {

    private RecommendContract.View mView;
    private Context mContext;


    public RecommendModule(RecommendContract.View mView,Context context) {
        this.mView = mView;
        this.mContext = context;
    }

    //创建presenter
    @Provides
    public RecommendContract.Presenter providePresenter(RecommendContract.View view, RecommendModel model){
        return  new RecommendPresenter(view,model);
    }
    @Provides
    public RecommendContract.View provideView(){
        return this.mView;
    }

    @Provides
    public RecommendModel provideModel(){
        return new RecommendModel();
    }

    @Provides
    public ProgressDialog provideDialog(Context context){
        return new ProgressDialog(context);
//        return RecommendAppAdapter();
    }

    @Provides
    public Context provideContext(){
        return this.mContext;
    }

}
