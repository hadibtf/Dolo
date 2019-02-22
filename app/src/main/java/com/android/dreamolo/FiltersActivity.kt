package com.android.dreamolo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_filters.*

//private const val DEBUG_TAG = "Velocity"

class FiltersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filters)

        seekbar.progresText = "${seekbar.progress} %"
        seekbar.setOnProgressChangeListener {
            seekbar.progresText = "$it %"
        }

//        seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                x += progress
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//                toast(x.toString())
//                amount.setWidth(x)
//
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//                toast(x.toString())
//                x = x
//                amount.setWidth(x)
//
//            }
//
//        })
    }
}
