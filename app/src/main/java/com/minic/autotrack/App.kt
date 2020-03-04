package com.minic.autotrack

import android.app.Application
import com.minic.track_android.code.ActivityLifeUtil


/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2020-03-04 14:42
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ActivityLifeUtil.init(this)
    }
}