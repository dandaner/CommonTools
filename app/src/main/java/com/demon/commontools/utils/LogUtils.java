package com.demon.commontools.utils;

import android.util.Log;

import com.demon.commontools.config.LibConfig;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author demon.zhang
 * @time 15/3/25 下午3:48
 */
public class LogUtils {

    private static final boolean LOG_ENBALE = LibConfig.LOG_ENABLE;
    public static final String TAG = LibConfig.TAG;

    public static void v(String subTag, String msg) {
        if (LOG_ENBALE) {
            Log.v(TAG, getLogMsg(subTag, msg));
        }
    }

    public static void d(String subTag, String msg) {
        if (LOG_ENBALE) {
            Log.d(TAG, getLogMsg(subTag, msg));
        }
    }

    public static void i(String subTag, String msg) {
        if (LOG_ENBALE) {
            Log.i(TAG, getLogMsg(subTag, msg));
        }
    }

    public static void w(String subTag, String msg) {
        if (LOG_ENBALE) {
            Log.w(TAG, getLogMsg(subTag, msg));
        }
    }

    public static void w(String subTag, String msg, Throwable e) {
        if (LOG_ENBALE) {
            Log.w(TAG, getLogMsg(subTag, msg + " Exception: " + getExceptionMsg(e)));
        }
    }

    public static void e(String subTag, String msg) {
        if (LOG_ENBALE) {
            Log.e(TAG, getLogMsg(subTag, msg));
        }
    }

    private static String getExceptionMsg(Throwable e) {
        StringWriter sw = new StringWriter(1024);
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        pw.close();
        return sw.toString();
    }

    private static String getLogMsg(String subTag, String msg) {
        return "[" + subTag + "] " + msg;
    }
}
