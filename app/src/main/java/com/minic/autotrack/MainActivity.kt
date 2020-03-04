package com.minic.autotrack

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.minic.track_android.code.ActivityLifeUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 埋点
        CommonTrack.track(this.application)

        tv_1?.setOnClickListener { view ->
        }

        tv_2?.setOnClickListener { view ->
        }

        tv_3?.setOnClickListener { view ->
        }
        tv_4?.setOnClickListener { view ->
        }
        tv_5?.setOnClickListener { view ->
        }

        tv_test?.setOnClickListener {
            startActivity(Intent(this, TwoActivity::class.java))
        }
    }
}
