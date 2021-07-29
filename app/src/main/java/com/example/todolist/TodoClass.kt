package com.example.todolist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoClass( var title:String
                     , var description:String,@PrimaryKey(autoGenerate = true) var i:Long? =null) {
}