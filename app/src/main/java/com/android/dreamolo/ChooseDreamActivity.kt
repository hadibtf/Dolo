package com.android.dreamolo

import adapters.PhotosRecyclerViewAdapter
import adapters.RecentRecyclerViewAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_choose_dream.*
import android.view.View.OnFocusChangeListener
import android.view.animation.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class ChooseDreamActivity : AppCompatActivity() {

    lateinit var recentRecyclerViewAdapter: RecentRecyclerViewAdapter
    lateinit var recentRecyclerViewLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_choose_dream)
        backBt.setOnClickListener { onBackPressed() }

        val fadeOut = AlphaAnimation(1f, 0f)
        fadeOut.interpolator = AccelerateInterpolator()
        fadeOut.startOffset = 0
        fadeOut.duration = 120
        fadeOut.isFillEnabled = true


        searchEdt.onFocusChangeListener = OnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                searchEdtHint.startAnimation(fadeOut)
                fadeOut.fillAfter = true
            } else {
                if (searchEdt.text.toString() == "") {
                    searchEdtHint.visibility = View.VISIBLE
                    fadeOut.fillAfter = false
                }
            }
        }

        recentRecyclerViewAdapter =
            RecentRecyclerViewAdapter(ArrayList(), object : RecentRecyclerViewAdapter.OnItemClickListener {
                override fun onItemClickListener(position: Int, productInfo: String) {
                    Toast.makeText(applicationContext, "$position", Toast.LENGTH_LONG).show()
                }
            })

        recentRecyclerViewLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        recentDreamsRv.apply {
            setHasFixedSize(true)
            layoutManager = recentRecyclerViewLayoutManager
            adapter = recentRecyclerViewAdapter
        }

        for (i in 0..9) recentRecyclerViewAdapter.addItem(i.toString(), recentRecyclerViewAdapter.itemCount)
    }
}
