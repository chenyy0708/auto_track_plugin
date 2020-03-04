package com.minic.track_android.code

import android.app.Activity


/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2020-01-16 14:06
 */
class ViewTag<T : Activity>(
    var id: Int = -1,
    val fromClazz: Class<T>,
    var toClazz: Class<*>? = null,
    var subscribe: Subscribe? = null
) {

    fun onView(viewId: Int): ViewTag<T> {
        this.id = viewId
        var mTags = Track.getInstance().mTrackIds[viewId]
        if (mTags == null) {
            mTags = mutableListOf()
            Track.getInstance().mTrackIds[id] = mTags
        }
        mTags.add(this)
        return this
    }

    fun toActivity(activity: Class<*>): ViewTag<*> {
        this.toClazz = activity
        return this
    }

    fun subscribe(subscribe: Subscribe) {
        this.subscribe = subscribe
    }
}