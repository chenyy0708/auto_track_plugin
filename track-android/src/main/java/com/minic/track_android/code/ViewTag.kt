package com.minic.track_android.code


/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2020-01-16 14:06
 */
class ViewTag(val id: Int, var subscribe: Subscribe? = null) {

    fun subscribe(subscribe: Subscribe) {
        this.subscribe = subscribe
    }
}