package com.hopson.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hopson.mvp.MainActivity;
import com.hopson.mvp.R;
import com.hopson.mvp.ui.adapter.GuideFragmentAdapter;
import com.hopson.mvp.ui.fragment.GuideFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.view_page)
    ViewPager viewPage;
    @BindView(R.id.btn_enter)
    Button btnEnter;

    private GuideFragmentAdapter guideFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

        initData();

    }

    private void initData(){

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(GuideFragment.newInstance(R.drawable.ic_launcher_foreground,R.color.colorAccent,R.string.app_name));
        fragments.add(GuideFragment.newInstance(R.drawable.ic_launcher_foreground,R.color.colorAccent,R.string.open));
        fragments.add(GuideFragment.newInstance(R.drawable.ic_launcher_foreground,R.color.colorAccent,R.string.close));

        guideFragmentAdapter = new GuideFragmentAdapter(getSupportFragmentManager());
        guideFragmentAdapter.setFragments(fragments);
        viewPage.setCurrentItem(0);
//        viewPage.setOffscreenPageLimit(guideFragmentAdapter.getCount());
        viewPage.setOnPageChangeListener(this);
        viewPage.setAdapter(guideFragmentAdapter);

    }


    @OnClick({R.id.view_page, R.id.btn_enter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.view_page:
                break;
            case R.id.btn_enter:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        btnEnter.setVisibility(position == guideFragmentAdapter.getCount()-1 ? View.VISIBLE : View.GONE);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
