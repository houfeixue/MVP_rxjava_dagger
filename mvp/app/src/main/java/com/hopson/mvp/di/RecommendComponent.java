package com.hopson.mvp.di;

import com.hopson.mvp.ui.fragment.RecommendFragment;

import dagger.Component;

@Component(modules = RecommendModule.class)
public interface RecommendComponent {

    void  inject(RecommendFragment fragment);

}
