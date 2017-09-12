package com.ahern.livinghelper.recreation.turingchat.adapter;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.recreation.turingchat.model.ChatModel;
import com.ahern.livinghelper.recreation.turingchat.model.ItemModel;

import java.util.ArrayList;

/**
 * Created by WangChang on 2016/4/28.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.BaseAdapter> {

    private ArrayList<ItemModel> dataList = new ArrayList<>();
    private OnURLClickListener mURLClickListener = null;

    public void replaceAll(ArrayList<ItemModel> list) {
        dataList.clear();
        if (list != null && list.size() > 0) {
            dataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void addAll(ArrayList<ItemModel> list) {
        int lastDataSize = dataList.size();
        if (dataList != null && list != null) {
            dataList.addAll(list);

            if (lastDataSize == 0){
                notifyDataSetChanged();
            }else{

                notifyItemRangeChanged(lastDataSize-1,list.size());
            }

        }

    }

    @Override
    public BaseAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ItemModel.CHAT_A:
                return new ChatAViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_a, parent, false));
            case ItemModel.CHAT_B:
                return new ChatBViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_b, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseAdapter holder, int position) {
        holder.setData(dataList.get(position).object);
        String url=((ChatModel)dataList.get(position).object).getUrl();


    }

    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).type;
    }

    @Override
    public int getItemCount() {
        return dataList != null ? dataList.size() : 0;
    }

    public class BaseAdapter extends RecyclerView.ViewHolder {

        public BaseAdapter(View itemView) {
            super(itemView);
        }

        void setData(Object object) {

        }
    }

    private class ChatAViewHolder extends BaseAdapter {
        private TextView tv;
        private TextView tv_link;

        public ChatAViewHolder(View view) {
            super(view);
            tv = (TextView) itemView.findViewById(R.id.tv);
            tv_link = (TextView) itemView.findViewById(R.id.tv_link);
            tv_link.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
            tv_link.getPaint().setAntiAlias(true);//抗锯齿
        }

        @Override
        void setData(Object object) {
            super.setData(object);
            final ChatModel model = (ChatModel) object;
            tv.setText(model.getContent());
            if (model.getUrl()!=null && !model.getUrl().equals("")){
                tv_link.setVisibility(View.VISIBLE);
                tv_link.setText(model.getUrl());
                tv_link.setVisibility(View.VISIBLE);
                tv_link.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mURLClickListener != null ){
                            mURLClickListener.onURLClick(model.getUrl());
                        }
                    }
                });
            }else{
                tv_link.setVisibility(View.GONE);
            }
        }
    }

    private class ChatBViewHolder extends BaseAdapter {
        private TextView tv;

        public ChatBViewHolder(View view) {
            super(view);
            tv = (TextView) itemView.findViewById(R.id.tv);

        }

        @Override
        void setData(Object object) {
            super.setData(object);
            ChatModel model = (ChatModel) object;
            tv.setText(model.getContent());
        }
    }




    public void setURLClickListener(OnURLClickListener listener) {
        this.mURLClickListener = listener;
    }

    public static interface OnURLClickListener {
        void onURLClick(String url);
    }
}
