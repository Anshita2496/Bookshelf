package com.hfad.calender.data.remote.request


import com.google.gson.annotations.SerializedName

data class TaskGetRequest(
    @SerializedName("user_id")
    val userId: Int
)