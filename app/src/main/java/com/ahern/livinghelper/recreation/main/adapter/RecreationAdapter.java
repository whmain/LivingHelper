package com.ahern.livinghelper.recreation.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.common.model.ItemEntity;

import java.util.List;

/**
 * @auther: WangHao on 2017/9/6 14:52
 * @email：Ahern.h.wang@emore-smart.com
 */

public class RecreationAdapter extends RecyclerView.Adapter<RecreationAdapter.ViewHolder> implements View.OnClickListener{

    private List<ItemEntity> list ;
    private OnItemClickListener mItemClickListener = null;
    private final static String LogTag = "RecreationAdapter";
    public  RecreationAdapter(List<ItemEntity> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_recreation_adapter,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTitleTv.setText(list.get(position).getTitle());
        holder.mIconIv.setImageResource(list.get(position).getImageID());
        holder.mIntroductionTv.setText(list.get(position).getIntroduction());
        holder.itemView.setOnClickListener(this);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mIconIv;
        public TextView mTitleTv;
        public TextView mIntroductionTv;
        public ViewHolder(View itemView) {
            super(itemView);
            mIconIv = (ImageView) itemView.findViewById(R.id.iv_recreation_adapter_item_icon);
            mTitleTv = (TextView) itemView.findViewById(R.id.tv_recreation_adapter_item_title);
            mIntroductionTv = (TextView) itemView.findViewById(R.id.tv_recreation_adapter_item_introduction);
        }
    }

    @Override
    public void onClick(View view) {
        Log.d(LogTag,"点击事件点点滴滴");
        if (mItemClickListener != null){
            mItemClickListener.onItemClick(view,(int)view.getTag());

        }
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mItemClickListener = listener;
    }

    public static interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

}
