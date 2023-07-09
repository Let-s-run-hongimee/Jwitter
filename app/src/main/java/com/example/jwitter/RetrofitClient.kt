package com.example.jwitter

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getRetrofitClient(): Retrofit? {
        return retrofit ?: let {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}


const val BASE_URL = "http://gcp.4n63l.com:8000"

