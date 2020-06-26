package com.hopson.mvp.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class GuideFragmentAdapter extends FragmentPagerAdapter {


    List<Fragment> mFragments;

    public void setFragments(List<Fragment> fragments) {

        if (fragments == null){
            fragments = new ArrayList<>();
        }else {
            this.mFragments = fragments;
        }
    }

    public GuideFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
