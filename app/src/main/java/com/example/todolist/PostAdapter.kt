package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.LayoutBinding

class PostAdapter(val post:ArrayList<TodoClass>):RecyclerView.Adapter<PostAdapter.PostViewHolder>()
{
    inner class PostViewHolder(val binding: LayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = LayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        holder.binding.tvTitle.text=post[position].title
        holder.binding.tvDescription.text=post[position].description
    }

    override fun getItemCount(): Int {
        return post.size
    }

}