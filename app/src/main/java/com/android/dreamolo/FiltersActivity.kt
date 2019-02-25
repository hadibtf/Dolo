package com.android.dreamolo

import adapters.SingleCategoryRecyclerViewAdapter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_filters.*
import org.jetbrains.anko.longToast
import tools.Assistant

class FiltersActivity : AppCompatActivity() {

    private lateinit var singleCategoryRecyclerViewLayoutManager: RecyclerView.LayoutManager
    private lateinit var singleCategoryRecyclerViewAdapter: SingleCategoryRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_filters)

        val asst = Assistant(this)

        singleCategoryRecyclerViewAdapter = SingleCategoryRecyclerViewAdapter(ArrayList(),
            object : SingleCategoryRecyclerViewAdapter.OnItemClickListener {
                override fun onItemClickListener(position: Int, productInfo: String, view: View) {
                    longToast("$position")
                }
            })


        singleCategoryRecyclerViewLayoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false
        )

        categoryRvOne.apply {
            setHasFixedSize(true)
            layoutManager = singleCategoryRecyclerViewLayoutManager
            adapter = singleCategoryRecyclerViewAdapter
        }

        for (i in 0..9) {
            singleCategoryRecyclerViewAdapter.addItem(i.toString(), singleCategoryRecyclerViewAdapter.itemCount)
        }

        asst.setViewWidthByWidth(seek1, 82.0, 100.0)
        asst.setViewWidthByWidth(seek2, 82.0, 100.0)
        asst.setViewHeightByHeight(seek1, 13.5, 100.0)
        asst.setViewHeightByHeight(seek2, 13.5, 100.0)


        //seekbar.setOnProgressChangeListener {
        //s?et seekBar progression  text
        //seekbar.progresText = "$it %"
        //}
        //set seekBar main text
        //seekbar.setText("Moon")
    }
}
