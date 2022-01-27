package com.prantokm.todo

import androidx.room.*

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(todo: ToDo)

    @Delete
    fun delete(todo: ToDo)
    //ordered by id
    @Query("Select * from ToDo order by id")
    fun getAll():List<ToDo>
}