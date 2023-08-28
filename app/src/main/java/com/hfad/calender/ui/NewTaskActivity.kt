package com.hfad.calender.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.hfad.calender.data.remote.request.CreateNewTaskRequest
import com.hfad.calender.data.remote.request.Task
import com.hfad.calender.databinding.ActivityNewTaskBinding
import com.hfad.calender.utils.Constants
import com.hfad.calender.utils.Constants.showNotifications
import com.hfad.calender.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewTaskBinding
    private val viewModel: TaskViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibProfileBackNewTask.setOnClickListener {
            startActivity(Intent(this, CreateTaskActivity::class.java))
        }


        binding.submitTask.setOnClickListener {
            val task = Task(
                binding.TaskDescription.text.toString(),
                binding.TaskName.text.toString()
            )
            val createnewTaskRequest = CreateNewTaskRequest(task, Constants.USER_ID)
            viewModel.postToApi(createnewTaskRequest)
            startActivity(Intent(this, ShowTaskActivity::class.java))
            finish()

        }

    }

}