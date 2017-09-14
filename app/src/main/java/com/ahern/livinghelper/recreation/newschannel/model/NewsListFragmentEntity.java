package com.ahern.livinghelper.recreation.newschannel.model;

import com.ahern.livinghelper.recreation.newschannel.ui.NewsListFragment;

/**
 * @auther: WangHao on 2017/9/13 10:56
 * @email：Ahern.h.wang@emore-smart.com
 */

public class NewsListFragmentEntity {

    private String title;
    private NewsListFragment fragment;

    public NewsListFragmentEntity(String title, NewsListFragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public NewsListFragment getFragment() {
        return fragment;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFragment(NewsListFragment fragment) {
        this.fragment = fragment;
    }
}
