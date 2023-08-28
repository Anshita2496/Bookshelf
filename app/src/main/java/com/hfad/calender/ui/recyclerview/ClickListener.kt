package com.hfad.calender.ui.recyclerview

import com.hfad.calender.data.local.TaskDatabaseModel

interface ClickListener {
    fun onClick(databaseModel: TaskDatabaseModel, position: Int)
}