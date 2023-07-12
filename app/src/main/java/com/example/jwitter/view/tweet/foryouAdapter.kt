package com.example.jwitter.view.tweet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jwitter.databinding.ItemRecylerviewBinding
import com.example.jwitter.tweet.TweetcreateResponse


class foryouAdapter : ListAdapter<Tweets, foryouAdapter.foryouViewHolder>(foryouCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): foryouViewHolder {
        val binding = ItemRecylerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return foryouViewHolder(binding)
    }

    override fun onBindViewHolder(holder: foryouViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class foryouViewHolder(private val binding: ItemRecylerviewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Tweets) {
            binding.apply {
                jwtnickname.text = item.nickname
                jwtusername.text = item.username
                jwtcontent.text = item.content
                jwtretweet.text = item.retweets.toString()
                jwtheart.text = item.hearts.toString()
            }
        }
    }

    companion object {
        private val foryouCallback = object : DiffUtil.ItemCallback<Tweets>() {
            override fun areItemsTheSame(oldItem: Tweets, newItem: Tweets): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: Tweets, newItem: Tweets): Boolean {
                return oldItem == newItem
            }
        }
    }


}