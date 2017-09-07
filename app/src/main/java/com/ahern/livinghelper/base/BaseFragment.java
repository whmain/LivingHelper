package com.ahern.livinghelper.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.ahern.livinghelper.common.utils.LogUtil;


/**
 * @auther: WangHao on 2017/6/14 11:01
 * @email：Ahern.h.wang@emore-smart.com
 */

public class BaseFragment extends Fragment {

    protected boolean isViewCreated = false;    //视图是否被创建
    protected boolean isFirstLoadData = true; //是否是第一次加载数据
    private String TAG = "BaseFragment";

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            lazyLoadData();
        }
    }


    /**
     * 懒加载方法
     * 子类Fragment可以在其中进行耗时操作
     */
    protected void  lazyLoadData(){

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.e(TAG, getClass().getSimpleName()+"--->onCreateView",true);
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtil.e(TAG, getClass().getSimpleName()+"--->onStart",true);
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.e(TAG, getClass().getSimpleName()+"--->onResume",true);
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtil.e(TAG, getClass().getSimpleName()+"--->onPause",true);
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtil.e(TAG, getClass().getSimpleName()+"--->onStop",true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.e(TAG, getClass().getSimpleName()+"--->onDestroyView",true);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.e(TAG, getClass().getSimpleName()+"--->onDestroy",true);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtil.e(TAG, getClass().getSimpleName()+"--->onDetach",true);

    }

}
