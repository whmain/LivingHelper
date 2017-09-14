package com.ahern.livinghelper.recreation.history.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.common.utils.LogUtil;
import com.ahern.livinghelper.recreation.history.model.HistoryListEntity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: WangHao on 2017/9/6 14:52
 * @email：Ahern.h.wang@emore-smart.com
 */

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ViewHolder> implements View.OnClickListener{

    private List<HistoryListEntity> list = new ArrayList<>();
    private OnItemClickListener mItemClickListener = null;
    private final static String LogTag = "RecreationAdapter";
    private Context context;
    public HistoryListAdapter(Context context) {
        this.context = context;
    }

    public void addData(List<HistoryListEntity> list,boolean isClear){
        if (isClear){
            this.list.clear();
        }
        this.list.addAll(list);
    }

    public HistoryListEntity getListItem(int position){
        return list.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_recreation_adapter,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
//        holder.mLayout.setCardBackgroundColor(Color.parseColor(ColorUtil.randomColor()));
        holder.mTitleTv.setText(list.get(position).getTitle());
        holder.mTimeTv.setText(String.format("时间:%d-%d-%d",list.get(position).getYear(),list.get(position).getMonth(),list.get(position).getDay()));
        holder.itemView.setOnClickListener(this);
        holder.itemView.setTag(position);
        LogUtil.i(LogTag,list.get(position).getTitle()+list.get(position).getPicUrl(),true);
//        Glide.with(context).load(list.get(position).getPicUrl()).placeholder(R.mipmap.ic_launcher).into(holder.mIconIv);
        //glide重复加载图片时，图片会被缩小,因此采用下面方式设定好mImageTv的宽高
        Glide.with(context).load(list.get(position).getPicUrl()).asBitmap().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new SimpleTarget<Bitmap>(140,140) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        holder.mIconIv.setImageBitmap(resource);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mIconIv;
        public TextView mTitleTv;
        public TextView mTimeTv;
        public CardView mLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            mIconIv = (ImageView) itemView.findViewById(R.id.iv_recreation_adapter_item_icon);
            mTitleTv = (TextView) itemView.findViewById(R.id.tv_recreation_adapter_item_title);
            mTimeTv = (TextView) itemView.findViewById(R.id.tv_recreation_adapter_item_introduction);
            mLayout = (CardView) itemView.findViewById(R.id.cv_recreation_layout);
        }
    }

    @Override
    public void onClick(View view) {

        if (mItemClickListener != null){
            mItemClickListener.onItemClick(view,(int)view.getTag());

        }
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mItemClickListener = listener;
    }

    public static interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

}
