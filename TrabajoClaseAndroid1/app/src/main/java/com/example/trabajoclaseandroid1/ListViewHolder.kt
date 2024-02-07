package com.example.trabajoclaseandroid1

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private  val tvListValue: TextView = view.findViewById(R.id.tvListValue)

    fun render(stringMessage: String){
        tvListValue.text = stringMessage
    }

}