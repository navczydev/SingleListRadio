package com.example.singlelistradio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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

        start_activity_2.setOnClickListener {
            //val toast = Toast.makeText(this,"yea, go ahead",Toast.LENGTH_LONG)
            //toast.show()
            startActivity(Intent(this,DynamicRadioGroup::class.java))
        }
    }

    override fun onItemClickListener(position: Int, view: View) {
        singleRecyclerViewAdapter.selectedItem()
    }
}
