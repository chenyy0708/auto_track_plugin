package com.minic.track_android.code;

import android.util.Log;
import android.view.View;

import java.util.Map;

/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2020-01-16 11:08
 */
public class AutoTrackHelper {

    private static final String TAG = "AutoTrackHelper";

    public static void trackViewOnClick(View view) {
        Log.d(TAG, "trackViewOnClick: " + view.getId());
        // 取出观察的埋点集合
        Map<Integer, ViewTag> mTrackIds = Track.Companion.getInstance().getMTrackIds();
        // 观察集合不为空
        if (mTrackIds.size() > 0) {
            ViewTag viewTag = mTrackIds.get(view.getId());
            if (viewTag != null && viewTag.getSubscribe() != null) {
                // 回调
                viewTag.getSubscribe().onSubscribe(view);
            }
        }
    }
}
