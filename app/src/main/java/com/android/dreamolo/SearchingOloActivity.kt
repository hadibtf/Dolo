package com.android.dreamolo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import kotlinx.android.synthetic.main.activity_searching_olo.*
import tools.Assistant


class SearchingOloActivity : AppCompatActivity() {

    lateinit var assistant: Assistant

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        assistant = Assistant(this)
        setContentView(R.layout.activity_searching_olo)
        yesBt.setOnClickListener {
            expandedLy.expand(true)
            expandedLy2.expand(true)
            val fadeOut = AlphaAnimation(1f, 0f)
            fadeOut.interpolator = AccelerateInterpolator() //and this
            fadeOut.duration = 300
//            fadeOut.isFillEnabled = true
//            fadeOut.fillAfter = true
            yesNoLy.startAnimation(fadeOut)
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationRepeat(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    yesNoLy.visibility = View.GONE
                    yesBt.isClickable = false
                    noBt.isClickable = false
                    oloCodeLy.visibility = View.VISIBLE
                }

                override fun onAnimationStart(animation: Animation?) {
                }

            })
        }
        cancelOloCodeBt.setOnClickListener {
            expandedLy2.collapse(true)
            expandedLy.collapse(true)
            yesNoLy.visibility = View.VISIBLE
            yesBt.isClickable = true
            noBt.isClickable = true
            oloCodeLy.visibility = View.GONE

        }
        noBt.setOnClickListener { startActivity(Intent(this, ChoosingOloActivity::class.java)) }
        val rotate = RotateAnimation(
            0f, 360f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
            0.5f
        )

        rotate.duration = 60000
        rotate.repeatMode = Animation.REVERSE
        rotate.repeatCount = Animation.INFINITE
        earthView.animation = rotate
    }
}
