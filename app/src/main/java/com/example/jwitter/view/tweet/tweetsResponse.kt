package com.example.jwitter.view.tweet

import com.squareup.moshi.Json

data class tweetsResponse(
    @field:Json(name = "Tweets")
    val Tweets: List<Tweets>?
)

data class Tweets(
    @field:Json(name = "tweet_id")
    val tweet_id: Int?,
    @field:Json(name = "user_id")
    val user_id: Int?,
    @field:Json(name = "nickname")
    val nickname: String?,
    @field:Json(name = "username")
    val username: String?,
    @field:Json(name = "content")
    val content: String?,
    @field:Json(name = "hearts")
    val hearts: Int?,
    @field:Json(name = "retweets")
    val retweets: Int?
)