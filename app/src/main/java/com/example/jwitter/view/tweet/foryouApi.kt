package com.example.jwitter.view.tweet

import retrofit2.Response
import retrofit2.http.Headers
import retrofit2.http.POST


interface foryouApi {

    @POST("/tweets/foryou")
    @Headers("Content-Type: application/json")
    suspend fun foryou(
    ): Response<tweetsResponse>
}

