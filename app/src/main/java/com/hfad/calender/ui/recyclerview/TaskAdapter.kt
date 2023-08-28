package com.hfad.calender.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hfad.calender.R
import com.hfad.calender.data.local.TaskDatabaseModel

class TaskAdapter(val list: ArrayList<TaskDatabaseModel>, val clickListener: ClickListener) :
    RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.task_layout,
                parent,
                false
            ), clickListener
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val data = list[position]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}