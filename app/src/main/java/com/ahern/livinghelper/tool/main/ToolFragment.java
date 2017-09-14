package com.ahern.livinghelper.tool.main;

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
import com.ahern.livinghelper.recreation.main.adapter.RecreationAdapter;
import com.ahern.livinghelper.tool.cookbook.ui.CookBookListActivity;
import com.ahern.livinghelper.tool.oneiromancy.ui.ConstellationActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @auther: WangHao on 2017/9/6 14:02
 * @email：Ahern.h.wang@emore-smart.com
 */

public class ToolFragment extends BaseFragment {
    View mView;
    @BindView(R.id.rv_tool)
    RecyclerView mToolRv;

    private Unbinder unbinder;
    private final static String LogTag = "ToolFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.inflate_tripartite, container, false);
        unbinder = ButterKnife.bind(this, mView);
        initView();
        return mView;
    }

    public void initView(){
        initRecyclerView();

    }

    public void initRecyclerView(){

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mToolRv.setLayoutManager(layoutManager);
        List<ItemEntity> items = new ArrayList<>();
        items.add(new ItemEntity(getResources().getString(R.string.item_oneiromancy),R.drawable.ic_oneiromancy,getResources().getString(R.string.item_introduction_oneiromancy)));
        items.add(new ItemEntity(getResources().getString(R.string.item_cookbook),R.drawable.ic_cookbook,getResources().getString(R.string.item_introduction_cookbook)));

        RecreationAdapter adapter = new RecreationAdapter(items);
        mToolRv.setAdapter(adapter);

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
                    startActivity(new Intent(getActivity(), ConstellationActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(getActivity(), CookBookListActivity.class));
                    break;
            }
        }
    };
}
