package com.ahern.livinghelper.recreation.newschannel.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.recreation.newschannel.model.NewsRequestEntity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: WangHao on 2017/9/13 16:28
 * @email：Ahern.h.wang@emore-smart.com
 */

public class NewListContentAdapter extends RecyclerView.Adapter<NewListContentAdapter.ViewHolder> implements View.OnClickListener{

    private List<NewsRequestEntity.ResultBeanX.ResultBean.ListBean> list = new ArrayList<>();
    private Context context;
    private OnItemClickListener mItemClickListener = null;

    public NewListContentAdapter(Context context) {
        this.context = context;

    }

    public void addData(List<NewsRequestEntity.ResultBeanX.ResultBean.ListBean> list,boolean isClear){
        int  lastListSize = this.list.size();
        if (isClear){
            this.list.clear();
            this.list.addAll(list);
            notifyDataSetChanged();
        }else{
            this.list.addAll(list);
            notifyItemRangeChanged(lastListSize-1,list.size());
        }
    }


    public NewsRequestEntity.ResultBeanX.ResultBean.ListBean getItem(int position){
        return list.get(position);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_news_list_adapter, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

//        Glide.with(context).load(list.get(position).getPic()).placeholder(R.mipmap.ic_launcher).into(holder.mImageIv);
        //glide重复加载图片时，图片会被缩小,因此采用下面方式设定好mImageTv的宽高
        Glide.with(context)
                .load(list.get(position).getPic())
                .asBitmap()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new SimpleTarget<Bitmap>(140,140) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        holder.mImageIv.setImageBitmap(resource);
                    }
                });
        holder.mTitleTv.setText(list.get(position).getTitle());
        holder.mTimeTv.setText(list.get(position).getTime());
        holder.itemView.setOnClickListener(this);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageIv;
        public TextView mTitleTv;
        public TextView mTimeTv;
        public ViewHolder(View itemView) {
            super(itemView);
            mImageIv = (ImageView) itemView.findViewById(R.id.iv_news_list_item_icon);
            mTitleTv = (TextView) itemView.findViewById(R.id.tv_news_list_item_title);
            mTimeTv = (TextView) itemView.findViewById(R.id.tv_news_list_item_time);
        }
    }

    @Override
    public void onClick(View view) {

        if (mItemClickListener != null) {
            mItemClickListener.onItemClick(view, (int) view.getTag());

        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
