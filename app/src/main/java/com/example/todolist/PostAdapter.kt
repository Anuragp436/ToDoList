package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.LayoutBinding

class PostAdapter(val post:ArrayList<TodoClass>,var listener: clickListener):RecyclerView.Adapter<PostAdapter.PostViewHolder>()
{
    inner class PostViewHolder(val binding: LayoutBinding): RecyclerView.ViewHolder(binding.root)
    {
        val kl=binding.idDlt
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =PostViewHolder(LayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        binding.kl.setOnClickListener{
            listener.onItemClick(post[binding.adapterPosition])
        }
        return binding
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        holder.binding.tvTitle.text=post[position].title
        holder.binding.tvDescription.text=post[position].description
    }

    override fun getItemCount(): Int {
        return post.size
    }

}
interface clickListener
{
    fun onItemClick(todo:TodoClass)
}