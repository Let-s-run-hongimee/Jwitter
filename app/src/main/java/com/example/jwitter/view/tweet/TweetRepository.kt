package com.example.jwitter.view.tweet

import com.example.jwitter.jwtToken
import com.example.jwitter.tweet.TweetcreateRequest
import com.example.jwitter.tweet.createtweetApi
import retrofit2.Response

class TweetRepository {

    suspend fun tweetcreate(tweetcreateRequest: TweetcreateRequest): Response<Unit> {
        return createtweetApi.tweetcreate(tweetcreateRequest)
    }
}