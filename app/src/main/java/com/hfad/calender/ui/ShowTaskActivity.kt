package com.hfad.calender.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hfad.calender.data.local.TaskDatabaseModel
import com.hfad.calender.data.remote.request.DeleteTaskRequest
import com.hfad.calender.data.remote.request.TaskGetRequest
import com.hfad.calender.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import com.hfad.calender.ui.recyclerview.ClickListener
import com.hfad.calender.ui.recyclerview.TaskAdapter
import com.hfad.calender.utils.Constants
import com.hfad.calender.utils.Constants.showNotifications
import com.hfad.calender.viewmodel.TaskViewModel

@AndroidEntryPoint
class ShowTaskActivity : AppCompatActivity(), ClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: TaskAdapter
    private var list = ArrayList<TaskDatabaseModel>()
    private val viewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.deleteFromDb()
        val taskGetRequest = TaskGetRequest(Constants.USER_ID)
        viewModel.saveDataToDB(taskGetRequest)
        viewModel.getTaskfromRepo().observe(this, Observer {
                list.clear()
                list.addAll(it)
                adapter.notifyDataSetChanged()
            })
            setRecyclerView()
        }

    private fun setRecyclerView() {
        adapter = TaskAdapter(list, this)
        val linearLayoutManager = LinearLayoutManager(this)
        binding.apply {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = linearLayoutManager
        }
    }

    override fun onClick(databaseModel: TaskDatabaseModel, position: Int) {
            viewModel.deleteFromApi(DeleteTaskRequest(databaseModel.task_id, Constants.USER_ID))
            viewModel.deleteTask(databaseModel)
            adapter.notifyDataSetChanged()
    }


}