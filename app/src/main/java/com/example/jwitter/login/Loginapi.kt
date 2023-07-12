package com.example.jwitter.login

import com.example.jwitter.RetrofitClient
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginApi {

    @POST("/users/login")
    @Headers("Content-Type: application/json")
    suspend fun login(@Body userLoginRequest: UserLoginRequest): Response<LoginResponse>
}

data class UserLoginRequest(
    val id: String,
    val password: String
)

data class LoginResponse(
    val access_token: String,
    val refresh_token: String
)

val userLoginAPI : LoginApi =
    RetrofitClient.getRetrofitClient()!!.create(LoginApi::class.java)