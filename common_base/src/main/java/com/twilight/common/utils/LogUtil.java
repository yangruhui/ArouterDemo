package com.twilight.common.utils;

import android.util.Log;
import com.twilight.common.constants.BuildConfig;

/**
 * 日志打印
 */
public class LogUtil {

    public static void d(final String tag, final String msg){
        if(BuildConfig.DEBUG) Log.d(tag,msg);
    }

    public static void e(final String tag, final String msg){
        if(BuildConfig.DEBUG) Log.e(tag,msg);
    }

    public static void e(final String tag, final String msg, Throwable tr){
        if(BuildConfig.DEBUG) Log.e(tag,msg,tr);
    }
}
