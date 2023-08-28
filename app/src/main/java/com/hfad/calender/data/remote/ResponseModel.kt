package com.hfad.calender.data.remote

import com.google.gson.annotations.SerializedName


data class ResponseModel(
    @SerializedName("tasks")
    val tasks: List<Task>
)