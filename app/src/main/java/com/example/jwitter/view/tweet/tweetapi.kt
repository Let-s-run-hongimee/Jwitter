/*
package com.example.jwitter.tweet

import androidx.lifecycle.viewModelScope
import com.example.jwitter.RetrofitClient
import com.example.jwitter.jwtToken
import com.example.jwitter.register.UserRegisterRequest
import com.example.jwitter.register.UserRegisterResponse
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface TweetcreateApi {
    @POST("/tweets/create")
    @Headers("Content-Type: application/json")
    suspend fun tweetcreate(@Body tweetcreateRequest: TweetcreateRequest): Response<TweetcreateResponse>
}

data class TweetcreateRequest(
    val content: String
)

data class TweetcreateResponse(
    val id: String,
    val content: String
)

val createtweetApi : TweetcreateApi =
RetrofitClient.getRetrofitClient()!!.create(TweetcreateApi::class.java)

*/
