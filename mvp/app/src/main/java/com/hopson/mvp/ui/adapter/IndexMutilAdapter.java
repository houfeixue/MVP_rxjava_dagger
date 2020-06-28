package com.hopson.mvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hopson.mvp.R;
import com.hopson.mvp.data.bean.AppInfo;
import com.hopson.mvp.data.http.ApiService;
import com.squareup.picasso.Picasso;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class IndexMutilAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final int TYPE_BANNER = 1;
    public static final int TYPE_ICON = 2;
    public static final int TYPE_APPS = 3;
    public static final int TYPE_GAMES = 4;



    private List<AppInfo> pageBean;

    private LayoutInflater layoutInflater;

    private Context mContext;

    BannerViewHolder bannerViewHolder;

    public IndexMutilAdapter(Context context) {
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);


    }

    public void setData(List<AppInfo> pageBean) {
        this.pageBean = pageBean;


    }

    //适合多布局
    @Override
    public int getItemViewType(int position) {
        if (position == 1) {
            return TYPE_BANNER;
        } else if (position == 0) {
            return TYPE_ICON;
        } else if (position == 2) {
            return TYPE_APPS;
        } else {
            return TYPE_GAMES;
        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_BANNER) {

            return new BannerViewHolder(layoutInflater.inflate(R.layout.template_banner, parent, false));
//            return new IconViewHolder(layoutInflater.inflate(R.layout.template_nav_icon, parent, false));

        } else if (viewType == TYPE_ICON) {
            return new IconViewHolder(layoutInflater.inflate(R.layout.template_nav_icon, parent, false));

        } else if (viewType == TYPE_APPS) {
            return new IconViewHolder(layoutInflater.inflate(R.layout.template_nav_icon, parent, false));

        } else if (viewType == TYPE_GAMES) {
            return new IconViewHolder(layoutInflater.inflate(R.layout.template_nav_icon, parent, false));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof BannerViewHolder) {
            bannerViewHolder = (BannerViewHolder) holder;
            bannerViewHolder.banner.setPages(pageBean,new MZHolderCreator<BannerItemViewHolder>() {
                @Override
                public BannerItemViewHolder createViewHolder() {
                    return new BannerItemViewHolder();
                }
            });
        } else if (holder instanceof IconViewHolder) {
            IconViewHolder iconViewHolder = (IconViewHolder) holder;

        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }


    class BannerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.banner)
        MZBannerView banner;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    class BannerItemViewHolder implements MZViewHolder<AppInfo>{
        private ImageView mImageView;
        private Context mContext;



        @Override
        public View createView(Context context) {
            this.mContext = context;
            // 返回页面布局
            mImageView =new ImageView(context);
            mImageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return mImageView;
        }

        @Override
        public void onBind(Context context, int position, AppInfo appInfo) {
            Picasso.with(this.mContext).load(ApiService.BASE_IMAGE_URL + appInfo.getBuildIcon()).into(mImageView);

        }

    }

    class IconViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.layout_hot_game)
        LinearLayout layoutHotGame;
        @BindView(R.id.layout_hot_subject)
        LinearLayout layoutHotSubject;
        @BindView(R.id.layout_hot_other)
        LinearLayout layoutHotOther;

        public IconViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}
