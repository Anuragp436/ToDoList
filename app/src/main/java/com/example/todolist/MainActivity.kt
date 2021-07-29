package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.todolist.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    val db by lazy {

        AppDatabase.getDatabase(
            this
        )
    }
     var todoArrayList= ArrayList<TodoClass>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
            val adapter = PostAdapter(todoArrayList)
            binding.rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rcView.adapter = adapter


            db.Dao().getAll().observe(this@MainActivity, Observer {
                                todoArrayList.clear()
                todoArrayList.addAll(it)

                adapter.notifyDataSetChanged()            })

binding.btIndex.setOnClickListener {

    val index=binding.etIndex.text.toString().toInt()
    val i=(todoArrayList.size).toLong()



    GlobalScope.launch(Dispatchers.IO) {
val kk=db.Dao().get(todoArrayList[index-1].title,todoArrayList[index-1].description)
Log.d("abde","$kk")
        db.Dao().delete(kk)
        val list=db.Dao().getAllNonLive()
        todoArrayList.clear()
        todoArrayList.addAll(list)
        adapter.notifyDataSetChanged()

    }


}
            binding.faButton.setOnClickListener {
                val intent=Intent(this@MainActivity, DataActivity::class.java)

                startActivity(intent)

            }
        }








    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.dltTodo) {
            startActivity(Intent(this@MainActivity, DeleteActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.delete_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
