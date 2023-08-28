package com.hfad.calender.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hfad.calender.data.local.TaskDatabaseModel
import com.hfad.calender.data.remote.request.CreateNewTaskRequest
import com.hfad.calender.data.remote.request.DeleteTaskRequest
import com.hfad.calender.data.remote.request.TaskGetRequest
import com.hfad.calender.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TaskViewModel @Inject constructor(val repo: TaskRepository) : ViewModel() {

    fun getTaskfromRepo(): LiveData<List<TaskDatabaseModel>> {
        return repo.getAllTasks()
    }

    fun saveDataToDB(taskGetRequest: TaskGetRequest) {
        repo.savetoDB(taskGetRequest)
    }

    fun postToApi(createNewTaskRequest: CreateNewTaskRequest) {
        repo.postTaskToApi(createNewTaskRequest)
    }

    fun deleteFromApi(deleteTaskRequest: DeleteTaskRequest) {
        repo.deleteFromApi(deleteTaskRequest)
    }

    fun deleteFromDb() {
        repo.deletAll()
    }

    fun deleteTask(taskDatabaseModel: TaskDatabaseModel) {
        repo.deleteTask(taskDatabaseModel)
    }
}