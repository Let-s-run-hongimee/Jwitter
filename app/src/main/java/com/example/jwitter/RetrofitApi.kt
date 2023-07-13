package com.example.jwitter

import com.example.jwitter.jwtToken.accesstoken
import com.example.jwitter.tweet.TweetcreateApi
import com.example.jwitter.view.tweet.foryouservice
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException

object RetrofitApi {

    private val BASE_URL = "http://152.70.36.251"

    fun okHttpClient(interceptor: AppInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient(AppInterceptor()))
            .baseUrl(BASE_URL)
            .build()
    }

    val foryouService: foryouservice by lazy {
        retrofit.create(foryouservice::class.java)
    }

    val tweetcreateService: TweetcreateApi by lazy {
        retrofit.create(TweetcreateApi::class.java)
    }


    class AppInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
            val accesstoken = MainApplication.prefs.getString(
                "accesstoken",
                ""
            ) ?: ""// ViewModel에서 지정한 key로 JWT 토큰을 가져온다.
            val newRequest = request().newBuilder()
                .addHeader("authorization", "Bearer ${accesstoken}") // 헤더에 authorization라는 key로 JWT 를 넣어준다.
                .build()
            proceed(newRequest)
        }


    }
}



