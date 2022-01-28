package com.prantokm.todo

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todo: ToDo)

    @Delete
    suspend fun delete(todo: ToDo)
    //ordered by id asc
    @Query("Select * from ToDo order by id ASC")
    fun getAllTask(): LiveData<List<ToDo>>
}