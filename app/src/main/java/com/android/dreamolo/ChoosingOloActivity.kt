package com.android.dreamolo

import adapters.OlosRecyclerViewAdapter
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.WindowManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_choosing_olo.*

class ChoosingOloActivity : AppCompatActivity() {

    lateinit var olosRecyclerViewAdapter: OlosRecyclerViewAdapter
    lateinit var olosRecyclerViewLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_choosing_olo)
//        page9.setOnClickListener { startActivity(Intent(this, DescribeWishActivity::class.java)) }
        olosRecyclerViewAdapter =
            OlosRecyclerViewAdapter(ArrayList(), object : OlosRecyclerViewAdapter.OnItemClickListener {
                override fun onItemClickListener(position: Int, productInfo: String) {
                    startActivity(Intent(applicationContext, WishDetailActivity::class.java))
                }
            })

        olosRecyclerViewLayoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        olosRv.apply {
            setHasFixedSize(true)
            layoutManager = olosRecyclerViewLayoutManager
            adapter = olosRecyclerViewAdapter
        }
        for (i in 0..9) olosRecyclerViewAdapter.addItem(i.toString(), olosRecyclerViewAdapter.itemCount)
    }
}
