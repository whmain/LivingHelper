package com.ahern.livinghelper.recreation.cookbook.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.recreation.cookbook.model.CookBookListEntity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: WangHao on 2017/9/11 16:41
 * @email：Ahern.h.wang@emore-smart.com
 */

public class CookBookListAdapter extends RecyclerView.Adapter<CookBookListAdapter.ViewHolder> implements View.OnClickListener{

    private List<CookBookListEntity.ResultBeanX.ResultBean.ListBean> list;
    private OnItemClickListener mItemClickListener = null;
    private Context context;
    public CookBookListAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    public void addAll(List<CookBookListEntity.ResultBeanX.ResultBean.ListBean> list){
        this.list.clear();
        this.list = list;
        notifyDataSetChanged();
    }

    public CookBookListEntity.ResultBeanX.ResultBean.ListBean getItem(int position){
        return list.get(position);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_cookbook_list_adapter,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getPic()).placeholder(R.mipmap.ic_launcher).into(holder.mCookIconiv);
        holder.mCookNameTv.setText(list.get(position).getName());
        holder.mpeopleNumTv.setText(list.get(position).getPeoplenum());
        holder.mCookTagTv.setText(list.get(position).getTag());
        holder.itemView.setOnClickListener(this);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mCookIconiv;
        public TextView mCookNameTv;
        public TextView mpeopleNumTv;//用餐人数
        public TextView mCookTagTv;
        public CardView mLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            mCookIconiv = (ImageView) itemView.findViewById(R.id.iv_cookbook_list_item_icon);
            mCookNameTv = (TextView) itemView.findViewById(R.id.tv_cook_name);
            mpeopleNumTv = (TextView) itemView.findViewById(R.id.tv_cool_peoplenum);
            mCookTagTv = (TextView) itemView.findViewById(R.id.tv_cook_label);
            mLayout = (CardView) itemView.findViewById(R.id.cv_cookbook_list_layout);

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
        void onItemClick(View view,int position);
    }
}
