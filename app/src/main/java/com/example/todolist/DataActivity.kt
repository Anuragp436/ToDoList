package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.todolist.databinding.ActivityDataBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DataActivity : AppCompatActivity() {

    val dd by lazy {
        AppDatabase.getDatabase(
            this
        )
    }
    private lateinit var binding: ActivityDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDataBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btSaveTodo.setOnClickListener {
            var title=binding.etTitle.text.toString()
            var description=binding.etDescription.text.toString()
            val t=TodoClass(title,description)

          GlobalScope.launch(Dispatchers.IO) {
              dd.Dao().insert(t)
          }


        }
    }
}