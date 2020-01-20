package com.minic.autotrack

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.minic.track_android.code.ActivityLifeUtil
import com.minic.track_android.code.Subscribe
import com.minic.track_android.code.Track
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        Track.getInstance().from(MainActivity::class.java).onView(R.id.tv_1)
            .subscribe(object : Subscribe {
                override fun onSubscribe(view: View) {
                    Toast.makeText(this@MainActivity, "tv_1", Toast.LENGTH_LONG).show()
                }
            })

        Track.getInstance().from(MainActivity::class.java).onView(R.id.tv_2)
            .subscribe(object : Subscribe {
                override fun onSubscribe(view: View) {
                    Toast.makeText(this@MainActivity, "MainActivity tv_2", Toast.LENGTH_LONG).show()
                }
            })

        Track.getInstance().from(TwoActivity::class.java).onView(R.id.tv_2)
            .subscribe(object : Subscribe {
                override fun onSubscribe(view: View) {
                    Toast.makeText(this@MainActivity, "TwoActivity tv_2", Toast.LENGTH_LONG).show()
                }
            })

        Track.getInstance().from(MainActivity::class.java).onView(R.id.tv_4)
            .subscribe(object : Subscribe {
                override fun onSubscribe(view: View) {
                    Toast.makeText(this@MainActivity, "tv_4", Toast.LENGTH_LONG).show()
                }
            })
    }
}
