package com.prantokm.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ToDoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this,
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(ToDoViewModel::class.java)

        viewModel.allToDo.observe(this, Observer {

        })
    }
}