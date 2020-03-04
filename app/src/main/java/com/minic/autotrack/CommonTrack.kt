package com.minic.autotrack

import android.app.Application
import android.view.View
import android.widget.Toast
import com.minic.track_android.code.Subscribe
import com.minic.track_android.code.Track


/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2020-03-04 14:25
 */
object CommonTrack {

    fun track(context: Application) {
        // MainActivity点击tv_1按钮
        Track.getInstance().fromActivity(MainActivity::class.java).onView(R.id.tv_1)
            .subscribe(object : Subscribe {
                override fun onSubscribe(view: View) {
                    Toast.makeText(context, "MainActivity tv_1", Toast.LENGTH_LONG).show()
                }
            })
        // MainActivity点击tv_2按钮
        Track.getInstance().fromActivity(MainActivity::class.java).onView(R.id.tv_2)
            .subscribe(object : Subscribe {
                override fun onSubscribe(view: View) {
                    Toast.makeText(context, "MainActivity tv_2", Toast.LENGTH_LONG).show()
                }
            })
        // TwoActivity点击tv_2按钮
        Track.getInstance().fromActivity(TwoActivity::class.java).onView(R.id.tv_2)
            .subscribe(object : Subscribe {
                override fun onSubscribe(view: View) {
                    Toast.makeText(context, "TwoActivity tv_2", Toast.LENGTH_LONG).show()
                }
            })
        // MainActivity点击tv_4按钮
        Track.getInstance().fromActivity(MainActivity::class.java).onView(R.id.tv_4)
            .subscribe(object : Subscribe {
                override fun onSubscribe(view: View) {
                    Toast.makeText(context, "MainActivity tv_4", Toast.LENGTH_LONG).show()
                }
            })
        Track.getInstance()
            .fromActivity(MainActivity::class.java)
            .toActivity(ThreeActivity::class.java)
            .onView(R.id.tv_4)
            .subscribe(object : Subscribe {
                override fun onSubscribe(view: View) {
                    Toast.makeText(
                        context,
                        "MainActivity 打开 ThreeActivity 点击了 tv_4",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }
}