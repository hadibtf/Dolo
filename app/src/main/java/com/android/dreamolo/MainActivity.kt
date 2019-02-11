package com.android.dreamolo

import adapters.PhotosRecyclerViewAdapter
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.TextViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var photosRecyclerViewAdapter: PhotosRecyclerViewAdapter
    private lateinit var photosRecyclerViewLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        page1.setOnClickListener { startActivity(Intent(this, DesignedDeramsOrMakeYourWishActivity::class.java)) }

        photosRecyclerViewAdapter =
            PhotosRecyclerViewAdapter(ArrayList(), object : PhotosRecyclerViewAdapter.OnItemClickListener {
                override fun onItemClickListener(position: Int, productInfo: String) {
                    Toast.makeText(applicationContext, "$position", Toast.LENGTH_LONG).show()
                }
            })

        photosRecyclerViewLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        photosRv.apply {
            setHasFixedSize(true)
            layoutManager = photosRecyclerViewLayoutManager
            adapter = photosRecyclerViewAdapter
        }

        for (i in 0..9) photosRecyclerViewAdapter.addItem(i.toString(), photosRecyclerViewAdapter.itemCount)

        TextViewCompat.setAutoSizeTextTypeWithDefaults(a, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
        TextViewCompat.setAutoSizeTextTypeWithDefaults(b, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
        TextViewCompat.setAutoSizeTextTypeWithDefaults(c, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
        TextViewCompat.setAutoSizeTextTypeWithDefaults(d, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
        TextViewCompat.setAutoSizeTextTypeWithDefaults(e, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
        TextViewCompat.setAutoSizeTextTypeWithDefaults(f, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
        TextViewCompat.setAutoSizeTextTypeWithDefaults(g, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
        TextViewCompat.setAutoSizeTextTypeWithDefaults(h, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
        TextViewCompat.setAutoSizeTextTypeWithDefaults(i, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM)
    }
}
