package com.example.singlelistradio

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.inputmethod.EditorInfo
import kotlinx.android.synthetic.main.searchview.*


class SearchViewSample: AppCompatActivity() {
    lateinit var exampleAdapter: ExampleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.searchview)
        val list = arrayListOf("Nav","Aabas","Gagan","Rock","Miya","Jiya","Rendi")
        exampleAdapter = ExampleAdapter(list)
        search_recycle.adapter = exampleAdapter
        //exampleAdapter.
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu,menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.imeOptions = EditorInfo.IME_ACTION_DONE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                exampleAdapter.filter.filter(newText)
                return false
            }
        })
        return true
    }
}