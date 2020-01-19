package com.minic.autotrack

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.minic.track_android.code.Subscribe
import com.minic.track_android.code.Track
import kotlinx.android.synthetic.main.activity_main.*

class OneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_1?.setOnClickListener { view ->
        }
    }
}
