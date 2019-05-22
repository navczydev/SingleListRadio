package com.example.singlelistradio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SingleRecyclerViewAdapter.SingleClickListener {
    private lateinit var singleRecyclerViewAdapter: SingleRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = arrayOf("JF","Joe","Nav", "Skander", "Samir")
        singleRecyclerViewAdapter = SingleRecyclerViewAdapter(list)
        single_fragment_recycler_view.adapter = singleRecyclerViewAdapter
        singleRecyclerViewAdapter.setOnItemClickListener(this)
    }

    override fun onItemClickListener(position: Int, view: View) {
        singleRecyclerViewAdapter.selectedItem()
    }
}
