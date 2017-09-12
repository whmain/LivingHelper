package com.ahern.livinghelper.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.LinearLayout;

import com.ahern.livinghelper.R;
import com.rmondjone.locktableview.DisplayUtil;
import com.rmondjone.locktableview.LockTableView;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    private LinearLayout mContentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mContentView=(LinearLayout)findViewById(R.id.contentView);
        initDisplayOpinion();

        //构造假数据
        ArrayList<ArrayList<String>> mTableDatas=new ArrayList<ArrayList<String>>();
        ArrayList<String> mfristData=new ArrayList<String>();
        mfristData.add("标题");
        for (int i=0;i<2;i++){
            mfristData.add("数据"+i);
        }
        mTableDatas.add(mfristData);
        for (int i=0;i<99;i++){
            ArrayList<String> mRowDatas=new ArrayList<String>();
            mRowDatas.add("标题"+i);
//            mRowDatas.add("数据11111111111"+i);
            for (int j=0;j<2;j++){
                mRowDatas.add("数据"+j);
            }
            mTableDatas.add(mRowDatas);
        }
        LockTableView mLockTableView=new LockTableView(this,mContentView,mTableDatas);
//        Log.e("列宽",(int)DisplayUtil.screenWidthDip/3+"");
        Log.e("表格加载开始","当前线程："+Thread.currentThread());
        mLockTableView.setLockFristColumn(true) //是否锁定第一列
                .setLockFristRow(true) //是否锁定第一行
                .setMaxColumnWidth(60) //列最大宽度
                .setMinColumnWidth(20) //列最小宽度
                .setMinRowHeight(5)//行最小高度
                .setMaxRowHeight(8)//行最大高度
                .setTextViewSize(8) //单元格字体大小
                .setFristRowBackGroudColor(R.color.table_head)//表头背景色
                .setTableHeadTextColor(R.color.beijin)//表头字体颜色
                .setTableContentTextColor(R.color.border_color)//单元格字体颜色
                .setNullableString("N/A") //空值替换值
                .setTableViewListener(new LockTableView.OnTableViewListener() {
                    @Override
                    public void onTableViewScrollChange(int x, int y) {
                        Log.e("滚动值","["+x+"]"+"["+y+"]");
                    }
                })//设置滚动回调监听
                .show(); //显示表格,此方法必须调用
        //属性值获取
        Log.e("每列最大宽度(dp)",mLockTableView.getColumnMaxWidths().toString());
        Log.e("每行最大高度(dp)",mLockTableView.getRowMaxHeights().toString());
        Log.e("表格所有的滚动视图",mLockTableView.getScrollViews().toString());
        Log.e("表格头部固定视图(锁列)",mLockTableView.getLockHeadView().toString());
        Log.e("表格头部固定视图(不锁列)",mLockTableView.getUnLockHeadView().toString());
    }

    private void initDisplayOpinion() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        DisplayUtil.density = dm.density;
        DisplayUtil.densityDPI = dm.densityDpi;
        DisplayUtil.screenWidthPx = dm.widthPixels;
        DisplayUtil.screenhightPx = dm.heightPixels;
        DisplayUtil.screenWidthDip = DisplayUtil.px2dip(getApplicationContext(), dm.widthPixels);
        DisplayUtil.screenHightDip = DisplayUtil.px2dip(getApplicationContext(), dm.heightPixels);

    }
}
