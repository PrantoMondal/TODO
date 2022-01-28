package com.prantokm.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast


import kotlinx.android.synthetic.main.activity_add_task.*

class AddTask : AppCompatActivity() {
    lateinit var viewModel: ToDoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

    }

    fun submitData(view: View) {
        val toDoText = input.text.toString()
        if (toDoText.isNotEmpty()){
            viewModel.insertTask(ToDo(toDoText))

        }
        val submit = findViewById<Button>(R.id.submit)
        submit.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}