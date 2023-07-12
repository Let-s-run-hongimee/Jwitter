package com.example.jwitter.view.tweet

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jwitter.tweet.TweetcreateRequest
import com.example.jwitter.tweet.TweetcreateResponse
import com.example.jwitter.view.tweet.TweetRepository
import kotlinx.coroutines.launch
import retrofit2.Response


class TweetViewModel(private val repository: TweetRepository) : ViewModel() {
    private val _tweetResponse = MutableLiveData<Response<TweetcreateResponse>>()
    val tweetResponse: LiveData<Response<TweetcreateResponse>> = _tweetResponse

    fun tweetCreate(tweetCreateRequest: TweetcreateRequest) {
        viewModelScope.launch {
            kotlin.runCatching {
                repository.tweetcreate(tweetCreateRequest)
            }.onSuccess { response ->
                _tweetResponse.postValue(response)
            }.onFailure {
                Log.e("TweetViewModel", "Failure: $it")
            }
        }
    }
}
