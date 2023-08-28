package com.hfad.calender.utils

import com.hfad.calender.data.remote.ResponseModel
import com.hfad.calender.data.remote.request.CreateNewTaskRequest
import com.hfad.calender.data.remote.request.DeleteTaskRequest
import com.hfad.calender.data.remote.request.TaskGetRequest
import retrofit2.http.*

interface ApiServices {

    @POST("/api/getCalendarTaskLists ")
    suspend fun getTaskFromAPI(@Body getTaskRequest: TaskGetRequest): ResponseModel

    @POST(" /api/deleteCalendarTask")
    suspend fun deleteTaskFromAPI(@Body deleteTask: DeleteTaskRequest)

    @POST("/api/storeCalendarTask")
    suspend fun createNewTaskToAPI(@Body createNewTask: CreateNewTaskRequest)
}