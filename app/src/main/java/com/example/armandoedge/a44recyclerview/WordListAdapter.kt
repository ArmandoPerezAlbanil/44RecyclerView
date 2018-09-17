package com.example.armandoedge.a44recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.View
import java.util.LinkedList

class WordListAdapter(context: Context, private val mWordList: LinkedList<String>) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    private val mInflater: LayoutInflater

    inner class WordViewHolder
    (itemView: View, val mAdapter: WordListAdapter) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val wordItemView: TextView

        init {
            wordItemView = itemView.findViewById(R.id.word) as TextView
            itemView.setOnClickListener(this)
        }

        @SuppressLint("SetTextI18n")
        override fun onClick(v: View) {
            // All we do here is prepend "Clicked! " to the text in the view, to verify that
            // the correct item was clicked. The underlying data does not change.
            wordItemView.text = "toque! " + wordItemView.text
        }
    }

    init {
        mInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        // Inflate an item view.
        val mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false)
        return WordViewHolder(mItemView, this)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        // Retrieve the data for that position.
        val mCurrent = mWordList[position]
        // Add the data to the view holder.
        holder.wordItemView.text = mCurrent
    }

    override fun getItemCount(): Int {
        return mWordList.size
    }
}
