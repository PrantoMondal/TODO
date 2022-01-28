package com.prantokm.todo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ToDoViewModel(application: Application) : AndroidViewModel(application) {
    val allToDo: LiveData<List<ToDo>>

    init {
        val dao = ToDoDatabase.getDatabase(application).getToDoDao()
        val repository = ToDoRepository(dao)
        allToDo = repository.allTask
    }

}