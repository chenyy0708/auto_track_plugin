package com.minic.track_android.code;

import android.content.Context;
import android.util.Log;
import android.view.View;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2020-01-16 11:08
 */
public class AutoTrackHelper {

    private static final String TAG = "AutoTrackHelper";

    public static void trackViewOnClick(View view) {
        if (view == null) return;
        Log.d(TAG, "trackViewOnClick: " + view.getId());
        // 取出观察的埋点集合
        Map<Integer, List<ViewTag<?>>> mTrackIds = Track.Companion.getInstance().getMTrackIds();
        // 观察集合不为空
        if (mTrackIds.size() > 0) {
            List<ViewTag<?>> viewTags = mTrackIds.get(view.getId());
            if (viewTags == null || viewTags.size() <= 0) return;
            // 循环取出标记的ViewTag
            for (ViewTag<?> viewTag : viewTags) {
                if (viewTag.getId() == view.getId()) {
                    // 只有目标Activity的view id才响应
                    Context viewContext = view.getContext();
                    // 不匹配
                    if (!viewTag.getClazz().isInstance(viewContext)) {
                        continue;
                    }
                    // 回调不为空
                    if (viewTag.getSubscribe() != null) {
                        viewTag.getSubscribe().onSubscribe(view);
                        // 匹配完成，跳出循环
                        break;
                    }
                }
            }
        }
    }
}
