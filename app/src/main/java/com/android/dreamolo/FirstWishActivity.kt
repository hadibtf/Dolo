package com.android.dreamolo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_first_wish.*
import kotlinx.android.synthetic.main.activity_main.*

class FirstWishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_first_wish)
        check_btn.setOnClickListener { startActivity(Intent(this, PaymentActivity::class.java)) }
    }
}
