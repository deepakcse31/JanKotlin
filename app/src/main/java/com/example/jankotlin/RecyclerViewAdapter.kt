package com.example.jankotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val mList: List<StudentInfoData>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
            val ItemsViewModel = mList[position]
            holder.textView.text = ItemsViewModel.userName
            holder.textView2.text = ItemsViewModel.enroll
    }
    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView = itemView.findViewById<TextView>(R.id.tvname)
        val textView2 = itemView.findViewById<TextView>(R.id.tvdesc)

    }
}