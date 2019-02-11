package com.android.dreamolo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

class DesignedDeramsOrMakeYourWishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_designed_derams_or_make_your_wish)
    }
}
