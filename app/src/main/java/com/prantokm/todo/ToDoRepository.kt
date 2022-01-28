package com.prantokm.todo

import androidx.lifecycle.LiveData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val allTask: LiveData<List<ToDo>> = toDoDao.getAllTask()

    suspend fun insert(toDo: ToDo){
        toDoDao.insert(toDo)
    }
    suspend fun delete(toDo:ToDo){
        toDoDao.delete(toDo)
    }


}