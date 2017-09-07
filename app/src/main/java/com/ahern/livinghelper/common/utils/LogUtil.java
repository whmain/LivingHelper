package com.ahern.livinghelper.common.utils;

import android.util.Log;

/**
 * @auther: WangHao on 2017/5/16 11:13
 * @email：Ahern.h.wang@emore-smart.com
 */

public class LogUtil {

    public static boolean OpenLog = true;

    public static void d(String tag,String msg,boolean isOpenCurrentLog){
        if (OpenLog && isOpenCurrentLog){
            Log.d(tag,msg);
        }
    }

    public static void i(String tag,String msg,boolean isOpenCurrentLog){
        if (OpenLog && isOpenCurrentLog){
            Log.i(tag,msg);
        }
    }

    public static void e(String tag,String msg,boolean isOpenCurrentLog){
        if (OpenLog && isOpenCurrentLog){
            Log.e(tag,msg);
        }
    }

    public static void w(String tag,String msg,boolean isOpenCurrentLog){
        if (OpenLog && isOpenCurrentLog){
            Log.w(tag,msg);
        }
    }
}
