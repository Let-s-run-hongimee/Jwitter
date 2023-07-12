package com.example.jwitter.view.tweet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jwitter.register.RegisterRepository
import com.example.jwitter.register.RegisterViewModel

class TweetViewModelFactory(private val repository: TweetRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TweetViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TweetViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
