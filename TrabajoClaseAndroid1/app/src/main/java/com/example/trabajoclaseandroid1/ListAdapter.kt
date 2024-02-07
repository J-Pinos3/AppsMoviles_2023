package com.example.trabajoclaseandroid1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val listStrings: List<String>): RecyclerView.Adapter<ListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_items_layout, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount() = listStrings.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.render(listStrings[position])
    }
}