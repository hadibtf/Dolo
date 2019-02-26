package com.android.dreamolo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager

class RankYourOloActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_rank_your_olo)
    }
}
