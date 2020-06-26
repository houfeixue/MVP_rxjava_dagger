package com.hopson.mvp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hopson.mvp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideFragment extends Fragment {

    public static final String IMG_ID = "IMG_ID";
    public static final String COLOR_ID = "COLOR_ID";
    public static final String TEXT_ID = "TEXT_ID";

    View mView;
    @BindView(R.id.imgview)
    ImageView imgview;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.rootView)
    LinearLayout rootView;

    public static GuideFragment newInstance(int imgResId, int bgColor, int textResId) {
        GuideFragment fragment = new GuideFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(IMG_ID, imgResId);
        bundle.putInt(COLOR_ID, bgColor);
        bundle.putInt(TEXT_ID, textResId);
        fragment.setArguments(bundle);
        return fragment;
    }

    ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_guide, container, false);
        ButterKnife.bind(this,mView);

        initData();

        return mView;
    }
    public void initData(){

        Bundle bundle = getArguments();

        int colorId = bundle.getInt(COLOR_ID);
        int imgId = bundle.getInt(IMG_ID);
        int textId = bundle.getInt(TEXT_ID);

        rootView.setBackgroundColor(getResources().getColor(colorId));
        imgview.setImageResource(imgId);
        text.setText(textId);
    }

}
