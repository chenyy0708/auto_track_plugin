package com.minic.track_android.code


/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2020-01-16 13:57
 */
class Track {
    /**
     * 记录需要埋点的View id
     */
    var mTrackIds = mutableMapOf<Int, ViewTag>()

    companion object {
        fun getInstance(): Track {
            return SingletonHolder.holder
        }
    }

    private object SingletonHolder {
        val holder = Track()
    }

    fun onView(viewId: Int): ViewTag {
        val viewTag = ViewTag(viewId)
        mTrackIds[viewId] = viewTag
        return viewTag
    }
}