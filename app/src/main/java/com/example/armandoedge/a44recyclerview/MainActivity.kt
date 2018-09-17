package com.example.armandoedge.a44recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import java.util.LinkedList


class MainActivity : AppCompatActivity() {
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: WordListAdapter? = null
    private val mWordList = LinkedList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// Put initial data into the word list.
        for (i in 0..19) {
            mWordList.addLast("palabras   $i")
        }

        // Create recycler view.
        mRecyclerView = findViewById(R.id.recyclerview) as RecyclerView

        // Create an adapter and supply the data to be displayed.
        mAdapter = WordListAdapter(this, mWordList)
        // Connect the adapter with the recycler view.
        mRecyclerView!!.adapter = mAdapter
        // Give the recycler view a default layout manager.
        mRecyclerView!!.layoutManager = LinearLayoutManager(this)

        // Add a floating action click handler for creating new entries.
        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            val wordListSize = mWordList.size
            // Add a new word to the wordList.
            mWordList.addLast("+ palabra $wordListSize")
            // Notify the adapter, that the data has changed.
            mRecyclerView!!.adapter?.notifyItemInserted(wordListSize)
            // Scroll to the bottom.
            mRecyclerView!!.smoothScrollToPosition(wordListSize)
        }
    }
}

