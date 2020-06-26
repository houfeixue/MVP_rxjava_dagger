package com.hopson.mvp.di.component;

import com.hopson.mvp.di.module.RecommendModule;
import com.hopson.mvp.di.scope.FragmentScope;
import com.hopson.mvp.ui.fragment.RecommendFragment;

import dagger.Component;
@FragmentScope
@Component(modules = RecommendModule.class,dependencies = AppCompenent.class)
public interface RecommendComponent {

    void  inject(RecommendFragment fragment);

}
