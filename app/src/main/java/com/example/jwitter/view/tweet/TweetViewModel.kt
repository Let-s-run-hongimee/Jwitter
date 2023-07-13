package com.example.jwitter.view.tweet

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jwitter.tweet.TweetcreateRequest
import com.example.jwitter.view.tweet.TweetRepository
import kotlinx.coroutines.launch
import retrofit2.Response


class TweetViewModel(private val repository: TweetRepository) : ViewModel() {
    private val _tweetResponse = MutableLiveData<Response<Unit>>()
    val tweetResponse: LiveData<Response<Unit>> = _tweetResponse

    fun tweetCreate(tweetCreateRequest: TweetcreateRequest) {
        viewModelScope.launch {
            kotlin.runCatching {
                repository.tweetcreate(tweetCreateRequest)
            }.onSuccess {
                if(it.isSuccessful) {
                    _tweetResponse.postValue(it)
                }
            }.onFailure {
                println("Failure.. &it")
            }
        }
    }
}
