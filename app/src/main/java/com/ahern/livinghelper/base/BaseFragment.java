package com.ahern.livinghelper.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.ahern.livinghelper.common.utils.LogUtil;


/**
 * @auther: WangHao on 2017/6/14 11:01
 * @email：Ahern.h.wang@emore-smart.com
 */

public class BaseFragment extends Fragment {

    protected boolean isViewCreated = false;    //视图是否被创建
    protected boolean isViewVisible = false;  //该fragment对于用户是否可见
//    protected boolean isLoadCompleted = false;  //数据是否加载完成,应在子类的loadData方法中判断
    private String TAG = "BaseFragment";

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            isViewVisible = true;
            lazyLoadData();
        }else{
           isViewVisible = false;
        }
    }


    //视图创建好之后，应将isViewCreated = true ; 视图销毁时，应将isViewCreated = false

    protected void  lazyLoadData(){
        if (isViewVisible && isViewCreated ){
            loadData();
        }
    }

    /**
     * 懒加载方法
     * 子类Fragment可以在其中进行耗时操作
     * Ps:
     * 1.更新UI时应当判断isViewCreated。
     */
    protected  void loadData(){

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        LogUtil.e(TAG, getClass().getSimpleName()+"--->onViewCreated",true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtil.e(TAG, getClass().getSimpleName()+"--->onActivityCreated",true);
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
        isViewCreated = false;
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
