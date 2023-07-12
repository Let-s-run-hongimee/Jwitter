package com.example.jwitter.view.tweet

import com.example.jwitter.jwtToken
import com.example.jwitter.tweet.TweetcreateRequest
import com.example.jwitter.tweet.TweetcreateResponse
import com.example.jwitter.tweet.createtweetApi
import retrofit2.Response

class TweetRepository {

    suspend fun tweetcreate(tweetcreaterequest: TweetcreateRequest) : Response<TweetcreateResponse> {
        return createtweetApi.tweetcreate("Bearer " + jwtToken.accesstoken, tweetcreaterequest)
    }
}