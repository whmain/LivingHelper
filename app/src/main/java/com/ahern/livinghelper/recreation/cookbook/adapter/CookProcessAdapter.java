package com.ahern.livinghelper.recreation.cookbook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.common.utils.LogUtil;
import com.ahern.livinghelper.recreation.cookbook.model.CookBookListEntity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: WangHao on 2017/9/12 14:03
 * @email：Ahern.h.wang@emore-smart.com
 */

public class CookProcessAdapter extends RecyclerView.Adapter<CookProcessAdapter.ViewHolder> {

    private List<CookBookListEntity.ResultBeanX.ResultBean.ListBean.ProcessBean> list;
    private Context context;

    public CookProcessAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void addAll(List<CookBookListEntity.ResultBeanX.ResultBean.ListBean.ProcessBean> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
        LogUtil.d("cookprocess","list的长度为:"+list.size(),true);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_cook_process_adapter_item,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextTv.setText("第"+(position+1)+"步:"+list.get(position).getPcontent().replace("<br />",""));
        Glide.with(context).load(list.get(position).getPic()).placeholder(R.mipmap.ic_launcher).into(holder.mPictureIv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextTv;
        public ImageView mPictureIv;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextTv = (TextView) itemView.findViewById(R.id.tv_cook_process_text);
            mPictureIv = (ImageView) itemView.findViewById(R.id.iv_cook_process_pic);

        }
    }
}
