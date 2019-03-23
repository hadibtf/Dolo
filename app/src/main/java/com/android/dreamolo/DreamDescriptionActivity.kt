package com.android.dreamolo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_dream_description.*

class DreamDescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_dream_description)
        i_want_it_btn.setOnClickListener { startActivity(Intent(this, RegistrationActivity::class.java)) }
        dreamDescriptionTv.text = "${resources.getText(R.string.lorem)} \n \n \n \n"
    }
}
