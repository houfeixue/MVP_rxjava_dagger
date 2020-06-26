package com.hopson.mvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hopson.mvp.R;
import com.hopson.mvp.data.bean.AppInfo;
import com.hopson.mvp.data.http.ApiService;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendAppAdapter extends RecyclerView.Adapter<RecommendAppAdapter.ViewHolder> {


    List<AppInfo> mDatas;
    Context mContext;
    private LayoutInflater layoutInflater;

    public RecommendAppAdapter(Context context, List<AppInfo> mDatas) {
        this.mDatas = mDatas;
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.template_recomand, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AppInfo appInfo = this.mDatas.get(position);

        Picasso.with(this.mContext).load(ApiService.BASE_IMAGE_URL + appInfo.getBuildIcon()).into(holder.imgIcon);
        holder.txtTitle.setText(appInfo.getBuildName());
        holder.txtSize.setText(appInfo.getBuildUpdateDescription());


    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return this.mDatas.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_icon)
        ImageView imgIcon;
        @BindView(R.id.txt_title)
        TextView txtTitle;
        @BindView(R.id.txt_size)
        TextView txtSize;
        @BindView(R.id.btn_dl)
        Button btnDl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
