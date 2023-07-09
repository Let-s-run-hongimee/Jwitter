/*
package com.example.jwitter.tweet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jwitter.jwtToken
import com.example.jwitter.register.UserRegisterResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class TweetViewModel(private val repository: TweetRepository): ViewModel() {
    private val _TweetcreateResponse = MutableLiveData<Response<TweetcreateResponse>>()
    val TweetcreateResponse: LiveData<Response<TweetcreateResponse>> = _TweetcreateResponse


    internal fun createTweet(tweetcreateRequest: TweetcreateRequest) {
        viewModelScope.launch {
            runCatching<Response<TweetcreateResponse>> {
                repository.tweetcreate(tweetcreateRequest)
            }.onSuccess {
                _TweetcreateResponse.postValue(it)
                if (it.isSuccessful) {
                   
                }
            }.onFailure {
                println("Failure.. $it")
            }
        }
    }
}*/
