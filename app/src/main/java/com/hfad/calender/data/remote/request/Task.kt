package com.hfad.calender.data.remote.request


import com.google.gson.annotations.SerializedName

data class Task(
    @SerializedName("description")
    val description: String,
    @SerializedName("title")
    val title: String
)