package com.example.jwitter.view.tweet

import android.telecom.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface foryouservice {
    @GET("/tweets/foryou")
    @Headers("Content-Type: application/json")

    suspend fun foryou(
    ): Response<TweetResponse>
}
