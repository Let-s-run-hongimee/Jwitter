package com.example.jwitter.view.tweet

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jwitter.databinding.FragmentHomeRecommendBinding
import com.example.jwitter.databinding.ItemRecylerviewBinding

class foryouAdapter : RecyclerView.Adapter<foryouHolder>() {


    var listData = mutableListOf<Tweets>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): foryouHolder {
        val binding =
            ItemRecylerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return foryouHolder(binding)
    }



    override fun onBindViewHolder(holder: foryouHolder, position: Int) {
        val post = listData.get(position)
        holder.setPost(post)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}



    class foryouHolder(val binding: ItemRecylerviewBinding) : RecyclerView.ViewHolder(binding.root) {


        fun setPost(post : Tweets) {
                binding.jwtnickname.text = post.nickname
                binding.jwtcontent.text = post.content
                binding.jwtusername.text = post.username
                binding.jwtretweet.text = post.retweets.toString()
                binding.jwtheart.text = post.hearts.toString()
        }
    }



//    companion object {
//        private val foryouCallback = object : DiffUtil.ItemCallback<Tweets>() {
//            override fun areItemsTheSame(oldItem: Tweets, newItem: Tweets): Boolean {
//                return oldItem.user_id == newItem.user_id
//            }
//
//            override fun areContentsTheSame(oldItem: Tweets, newItem: Tweets): Boolean {
//                return oldItem == newItem
//            }
//
//        }
//
//    }
