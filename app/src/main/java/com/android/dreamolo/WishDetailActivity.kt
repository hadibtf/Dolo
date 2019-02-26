package com.android.dreamolo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.view.animation.TranslateAnimation
import com.pawegio.kandroid.animListener
import kotlinx.android.synthetic.main.activity_wish_detail.*


class WishDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_wish_detail)

        init()

        onClickListeners()
    }

    private fun onClickListeners() {
        more.setOnClickListener {
            if (!moreTxtExpandable.isExpanded) {
                val animateSlideDown = TranslateAnimation(0f, 0f, -previewTxt.height.toFloat(), 0f)
                animateSlideDown.duration = 50
                animateSlideDown.fillAfter = true

                val animateSlideUp = TranslateAnimation(0f, 0f, 0f, -previewTxt.height.toFloat())
                animateSlideUp.duration = 0
                animateSlideUp.fillAfter = true
                previewTxt.startAnimation(animateSlideUp)
                moreTxtExpandable.expand(true)
                animateSlideUp.animListener {
                    onAnimationEnd {
                        previewTxt.visibility = View.GONE
                    }
                }

            } else {
                previewTxt.visibility = View.INVISIBLE
                val animateSlideDown = TranslateAnimation(0f, 0f, -previewTxt.height.toFloat(), 0f)
                animateSlideDown.duration = 250
                animateSlideDown.startOffset = 250
                animateSlideDown.fillAfter = true

                val animateSlideUp = TranslateAnimation(0f, 0f, 0f, -previewTxt.height.toFloat())
                animateSlideUp.duration = 250
                animateSlideUp.fillAfter = true

                previewTxt.startAnimation(animateSlideDown)
                moreTxtExpandable.collapse(true)
            }

        }
    }

    private fun init() {

    }
}
