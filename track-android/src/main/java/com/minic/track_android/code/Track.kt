package com.minic.track_android.code

import android.app.Activity


/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2020-01-16 13:57
 */
class Track {
    /**
     * 记录需要埋点的View id
     */
    var mTrackIds = mutableMapOf<Int, MutableList<ViewTag<*>>>()

    companion object {
        fun getInstance(): Track {
            return SingletonHolder.holder
        }
    }

    private object SingletonHolder {
        val holder = Track()
    }

    fun <T : Activity> fromActivity(activity: Class<T>): ViewTag<T> {
        return ViewTag(fromClazz = activity)
    }
}