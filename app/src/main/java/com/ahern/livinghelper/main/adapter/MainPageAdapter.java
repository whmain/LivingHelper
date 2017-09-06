package com.ahern.livinghelper.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @auther: WangHao on 2017/9/6 14:04
 * @email：Ahern.h.wang@emore-smart.com
 */

public class MainPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;

    public MainPageAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
