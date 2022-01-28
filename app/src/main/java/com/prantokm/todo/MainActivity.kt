package com.prantokm.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.LineNumberReader

class MainActivity : AppCompatActivity(), IToDoRVAdapter {
    lateinit var viewModel: ToDoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addTask = findViewById<ImageButton>(R.id.addTask)
        addTask.setOnClickListener{
            val intent = Intent(this,AddTask::class.java)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ToDoRVAdapter(this,this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this,
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(ToDoViewModel::class.java)

        viewModel.allToDo.observe(this, Observer {list->
            list?.let {
                adapter.updateList(it)
            }


        })

    }

    override fun onItemClicked(toDo: ToDo) {
        viewModel.doneTask(toDo)

    }
}