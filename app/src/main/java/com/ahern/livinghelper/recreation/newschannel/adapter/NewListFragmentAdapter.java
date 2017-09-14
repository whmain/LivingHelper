package com.ahern.livinghelper.recreation.newschannel.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ahern.livinghelper.recreation.newschannel.model.NewsListFragmentEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: WangHao on 2017/9/13 10:51
 * @email：Ahern.h.wang@emore-smart.com
 */

public class NewListFragmentAdapter extends FragmentPagerAdapter {

    private List<NewsListFragmentEntity> list;


    public NewListFragmentAdapter(FragmentManager fm) {
        super(fm);
        list = new ArrayList<>();
    }

    public void addData(List<NewsListFragmentEntity> list){
        this.list.clear();
        this.list = list;
        notifyDataSetChanged();
    }

    public NewsListFragmentEntity getData(int position){
        return list.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getTitle();
    }
}
