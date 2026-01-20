package com.example.jankotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentDetailsAdapter(private val studentList: List<StudentData>) :
    RecyclerView.Adapter<StudentDetailsAdapter.StudentDetailsViewHolder>() {

    class StudentDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvname)
        val tvRollNo = itemView.findViewById<TextView>(R.id.tvrollno)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentDetailsViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_list_item, parent, false)
        return StudentDetailsViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: StudentDetailsViewHolder, position: Int) {
        val currentItem = studentList[position]
        holder.tvName.text = currentItem.name
        holder.tvRollNo.text = currentItem.rollNo
    }

    override fun getItemCount(): Int {
       return studentList.size
    }

}