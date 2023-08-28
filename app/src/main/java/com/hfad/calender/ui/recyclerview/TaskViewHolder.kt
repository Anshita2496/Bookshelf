package com.hfad.calender.ui.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.hfad.calender.data.local.TaskDatabaseModel
import com.hfad.calender.databinding.TaskLayoutBinding

class TaskViewHolder(val itemLayoutBinding: TaskLayoutBinding, val clickListener: ClickListener) :
    RecyclerView.ViewHolder(itemLayoutBinding.root) {

    fun setData(result: TaskDatabaseModel) {
        itemLayoutBinding.apply {
            tvTitle.text = result.title
            tvDescription.text = result.description

            ivDelete.setOnClickListener {
                clickListener.onClick(result, adapterPosition)
            }
        }
    }
}