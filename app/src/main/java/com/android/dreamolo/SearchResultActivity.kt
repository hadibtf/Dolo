package com.android.dreamolo

import adapters.RecentRecyclerViewAdapter
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_search_result.*

class SearchResultActivity : AppCompatActivity() {
    lateinit var searchResultRecyclerViewAdapter: RecentRecyclerViewAdapter
    lateinit var searchResultRecyclerViewLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_search_result)

        searchResultBackBt.setOnClickListener { onBackPressed() }
        page5.setOnClickListener { startActivity(Intent(this, DreamDescriptionActivity::class.java)) }
        searchResultRecyclerViewAdapter =
            RecentRecyclerViewAdapter(ArrayList(), object : RecentRecyclerViewAdapter.OnItemClickListener {
                override fun onItemClickListener(position: Int, productInfo: String) {
                    Toast.makeText(applicationContext, "$position", Toast.LENGTH_SHORT).show()
                }
            })

        searchResultRecyclerViewLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        searchResultRV.apply {
            setHasFixedSize(true)
            layoutManager = searchResultRecyclerViewLayoutManager
            adapter = searchResultRecyclerViewAdapter
        }

        for (i in 0..9) searchResultRecyclerViewAdapter.addItem(i.toString(), searchResultRecyclerViewAdapter.itemCount)

    }
}
