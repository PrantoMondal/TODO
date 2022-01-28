package com.prantokm.todo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
class ToDo (@ColumnInfo(name = "text")val text:String) {
    @PrimaryKey(autoGenerate = true)val id=1

}