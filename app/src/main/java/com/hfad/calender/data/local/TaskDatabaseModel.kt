package com.hfad.calender.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasktable")
class TaskDatabaseModel(
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "task_id")
    val task_id: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null

}