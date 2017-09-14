package com.ahern.livinghelper.tool.oneiromancy.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.common.utils.ColorUtil;
import com.ahern.livinghelper.tool.oneiromancy.model.DreamBriefEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: WangHao on 2017/9/8 10:16
 * @email：Ahern.h.wang@emore-smart.com
 */

public class DreamListAdapter extends RecyclerView.Adapter<DreamListAdapter.ViewHolder> implements View.OnClickListener {

    private List<DreamBriefEntity> list = new ArrayList<>();
    private OnItemClickListener mItemClickListener = null;
    private Context context;

    public DreamListAdapter(Context context) {
        this.context = context;
    }

    public void addData(List<DreamBriefEntity> list, boolean isClear) {
        if (isClear) {
            this.list.clear();
        }
        this.list.addAll(list);
    }

    public DreamBriefEntity getListItem(int position) {
        return list.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_dream_brief_adapter, parent, false);
        DreamListAdapter.ViewHolder holder = new DreamListAdapter.ViewHolder(view);

        return holder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mLayout.setCardBackgroundColor(Color.parseColor(ColorUtil.randomColor()));
        holder.mTitleTv.setText(list.get(position).getTitle());
        holder.mDescriptionTv.setText(list.get(position).getDescription());
        holder.itemView.setOnClickListener(this);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitleTv;
        public TextView mDescriptionTv;
        public CardView mLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            mTitleTv = (TextView) itemView.findViewById(R.id.tv_dream_brief_adapter_item_title);
            mDescriptionTv = (TextView) itemView.findViewById(R.id.tv_dream_brief_adapter_item_description);
            mLayout = (CardView) itemView.findViewById(R.id.cv_brief_draem_layout);
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
