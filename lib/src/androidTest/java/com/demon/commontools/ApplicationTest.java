package com.demon.commontools;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;

import com.demon.commontools.net.NetworkUtil;
import com.demon.commontools.utils.LogUtils;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    private static final String TAG = "ApplicationTest";

    public void testNetworkUtil() {
        Context ctx = getContext();
        boolean enable = NetworkUtil.isNetworkAvaialble(ctx);
        int networkType = NetworkUtil.getNetworkType(ctx);
        int simpleNetworkType = NetworkUtil.getSimpleNetworkType(ctx);
        LogUtils.d(TAG, "enable = " + enable + "  networkType = "
                + networkType + "   simpleNetworkType = " + simpleNetworkType);
//        throw new RuntimeException("ahahahha");
    }
}