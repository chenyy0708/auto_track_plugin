package com.minic.track_android.code;

import android.app.Activity;
import android.util.Log;

/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2020-01-20 15:18
 */
public class ActivityLifeUtil {

    public static final String TAG = "ActivityLifeUtil";

    public static void onActivityCreated(Activity activity) {
        Log.d(TAG, "onActivityCreated:" + activity.getClass().getSimpleName());
    }

    public static void onActivityStarted(Activity activity) {
        Log.d(TAG, "onActivityStarted:" + activity.getClass().getSimpleName());
    }

    public static void onActivityResumed(Activity activity) {
        Log.d(TAG, "onActivityResumed:" + activity.getClass().getSimpleName());
    }

    public static void onActivityPaused(Activity activity) {
        Log.d(TAG, "onActivityPaused:" + activity.getClass().getSimpleName());
    }

    public static void onActivityStopped(Activity activity) {
        Log.d(TAG, "onActivityStopped:" + activity.getClass().getSimpleName());
    }

    public static void onActivityDestroyed(Activity activity) {
        Log.d(TAG, "onActivityDestroyed:" + activity.getClass().getSimpleName());
    }
}
