
package com.example.jwitter.tweet

import com.example.jwitter.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface TweetcreateApi {
    @POST("/tweets/create")
    @Headers("Content-Type: application/json")
    suspend fun tweetcreate(
        @Header("Authorization") authorization: String,
        @Body tweetcreateRequest: TweetcreateRequest
    ): Response<TweetcreateResponse>
}


    
data class TweetcreateRequest(
    val content: String
)

data class TweetcreateResponse(
    val id: String,
    val username: String,
    val nickname: String,
    val content: String,
    val hearts: Int,
    val retweets: Int
)


val createtweetApi : TweetcreateApi =
RetrofitClient.getRetrofitClient()!!.create(TweetcreateApi::class.java)

