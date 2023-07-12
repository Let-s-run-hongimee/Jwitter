package com.example.jwitter.view.tweet

data class Tweet(var id: String,
                var username: String,
                var nickname: String,
                var content: String,
                var hearts: Int,
                var retweets: Int)