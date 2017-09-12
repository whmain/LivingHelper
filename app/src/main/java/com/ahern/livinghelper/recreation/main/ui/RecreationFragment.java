package com.ahern.livinghelper.recreation.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahern.livinghelper.R;
import com.ahern.livinghelper.base.BaseFragment;
import com.ahern.livinghelper.common.model.ItemEntity;
import com.ahern.livinghelper.recreation.constellation.ui.ConstellationActivity;
import com.ahern.livinghelper.recreation.cookbook.ui.CookBookListActivity;
import com.ahern.livinghelper.recreation.history.ui.HistoryActivity;
import com.ahern.livinghelper.recreation.main.adapter.RecreationAdapter;
import com.ahern.livinghelper.recreation.turingchat.ui.TuringChatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @auther: WangHao on 2017/9/6 14:01
 * @email：Ahern.h.wang@emore-smart.com
 */

public class RecreationFragment extends BaseFragment {

    View mView;
    @BindView(R.id.rv_recreation)
    RecyclerView mRecreationRv;

    private Unbinder unbinder;
    private final static String LogTag = "RecreationFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.inflate_recreation, container, false);
        unbinder = ButterKnife.bind(this, mView);
        initView();
        return mView;
    }

    public void initView(){
        initRecyclerView();

    }

    public void initRecyclerView(){

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mRecreationRv.setLayoutManager(layoutManager);
        List<ItemEntity> items = new ArrayList<>();
        items.add(new ItemEntity(getResources().getString(R.string.item_history),R.drawable.ic_history,getResources().getString(R.string.item_introduction_history)));
        items.add(new ItemEntity(getResources().getString(R.string.item_turing),R.drawable.ic_turing,getResources().getString(R.string.item_introduction_turing)));
        items.add(new ItemEntity(getResources().getString(R.string.item_cookbook),R.drawable.ic_cookbook,getResources().getString(R.string.item_introduction_cookbook)));
        items.add(new ItemEntity(getResources().getString(R.string.item_oneiromancy),R.drawable.ic_oneiromancy,getResources().getString(R.string.item_introduction_oneiromancy)));
        RecreationAdapter adapter = new RecreationAdapter(items);
//       设置item间距
//        SpaceItemDecoration decoration = new SpaceItemDecoration(0);
//        mRecreationRv.addItemDecoration(decoration);

        mRecreationRv.setAdapter(adapter);

        adapter.setOnItemClickListener(mItemClickListener);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

  /*
  * item点击事件
  * */
    RecreationAdapter.OnItemClickListener mItemClickListener = new RecreationAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            switch (position){
                case 0:
                    startActivity(new Intent(getActivity(), HistoryActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(getActivity(), TuringChatActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(getActivity(), CookBookListActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(getActivity(), ConstellationActivity.class));
                    break;
            }
        }
    };
}
