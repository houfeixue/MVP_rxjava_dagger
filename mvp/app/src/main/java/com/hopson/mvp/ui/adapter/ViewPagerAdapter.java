package com.hopson.mvp.ui.adapter;

import com.hopson.mvp.data.bean.FragmentInfo;
import com.hopson.mvp.ui.fragment.CategoryFragment;
import com.hopson.mvp.ui.fragment.GameFragment;
import com.hopson.mvp.ui.fragment.RankingFragment;
import com.hopson.mvp.ui.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<FragmentInfo> mFragments = new ArrayList<>(4) ;


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        initFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        FragmentInfo fragmentInfo = mFragments.get(position);

        return fragmentInfo.getTitle();
    }
    private  void  initFragment(){
        mFragments.add(new FragmentInfo("推荐",RecommendFragment.class));
        mFragments.add(new  FragmentInfo("排行",RankingFragment.class));
        mFragments.add(new FragmentInfo("分类",CategoryFragment.class));
        mFragments.add(new FragmentInfo("游戏",GameFragment.class));

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Class fragmentInfo = mFragments.get(position).getFragment();
        try {
            return (Fragment) fragmentInfo.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
