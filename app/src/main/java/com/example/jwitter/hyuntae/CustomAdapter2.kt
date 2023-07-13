package com.example.jwitter.hyuntae


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.jwitter.databinding.PostBinding
import java.text.SimpleDateFormat

class CustomAdapter2 : RecyclerView.Adapter<Holder2>() {

    var listData = mutableListOf<postData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder2 {
        val binding = PostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder2(binding)
    }

    override fun onBindViewHolder(holder: Holder2, position: Int) {
        val post = listData.get(position)
        holder.setPost(post)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}

class Holder2(val binding: PostBinding) : RecyclerView.ViewHolder(binding.root) {


    fun setPost(post : postData) {
        binding.profileID.text = "${post.no}"
        binding.profileNAME.text = post.name
        binding.postText.text = post.text
        binding.ChatCount.text = "${post.Chat}"
        binding.retweetCount.text = "${post.retweet}"
        binding.ILikeItCount.text = "${post.like}"
        binding.viewsCount.text = "${post.views}"
    }
}