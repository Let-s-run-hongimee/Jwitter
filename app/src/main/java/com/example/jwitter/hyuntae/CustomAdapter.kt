package com.example.jwitter.hyuntae


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jwitter.databinding.ItemBinding

class CustomAdapter : RecyclerView.Adapter<Holder>() {

    var listData = mutableListOf<userData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val user = listData.get(position)
        holder.setUser(user)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}

class Holder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {


    fun setUser(user : userData) {
        binding.textNo.text = "${user.no}"
        binding.textName.text = user.name

    }
}