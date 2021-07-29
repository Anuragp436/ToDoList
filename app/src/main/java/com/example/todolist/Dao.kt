package com.example.todolist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {
    @Insert
    suspend fun insert(todoClass: TodoClass)

    @Query("SELECT * FROM TodoClass WHERE title=:tit AND description=:des")
    suspend fun get(tit:String,des:String):TodoClass

    @Query("SELECT * FROM TodoClass")
   fun getAll():LiveData<List<TodoClass>>

   @Delete
  suspend fun delete(todoClass: TodoClass)

    @Query("SELECT * FROM TodoClass")
   suspend fun getAllNonLive():List<TodoClass>
}