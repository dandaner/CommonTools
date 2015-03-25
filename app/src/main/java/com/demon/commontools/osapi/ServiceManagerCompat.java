package com.demon.commontools.osapi;

import android.os.IBinder;

import com.demon.commontools.utils.LogUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ServiceManagerCompat {
    private static final String TAG = "ServiceManagerCompat";

    private static final String CLASSNAME_SERVICE_MANAGER = "android.os.ServiceManager";

    private static Class<?> sServiceManagerClass;
    private static Method sGetServiceMethod;

    static {
        try {
            sServiceManagerClass = Class.forName(CLASSNAME_SERVICE_MANAGER, false, Thread.currentThread().getContextClassLoader());
            sGetServiceMethod = sServiceManagerClass.getMethod("getService", new Class[]{String.class});
        } catch (ClassNotFoundException e) {
            LogUtils.w(TAG, "unexpected", e);
        } catch (NoSuchMethodException e) {
            LogUtils.w(TAG, "unexpected", e);
        }
    }

    public static IBinder getService(Object name) {
        if (sGetServiceMethod != null) {
            try {
                Method localMethod = sGetServiceMethod;
                Object[] arrayOfObject = new Object[]{name};
                Object ret = localMethod.invoke(null, arrayOfObject);
                return (IBinder) ret;
            } catch (IllegalAccessException e) {
                LogUtils.w(TAG, "unexpected", e);
            } catch (InvocationTargetException e) {
                LogUtils.w(TAG, "unexpected", e);
            } catch (Exception e) {
                LogUtils.w(TAG, "unexpected", e);
            }
        }
        return null;
    }
}
