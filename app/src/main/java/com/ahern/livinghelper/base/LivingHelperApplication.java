package com.ahern.livinghelper.base;

import android.app.Application;

import com.ahern.livinghelper.common.utils.LogUtil;

/**
 * @auther: WangHao on 2017/9/6 14:20
 * @email：Ahern.h.wang@emore-smart.com
 */

public class LivingHelperApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.OpenLog = true;

    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }
}
