package com.example.jwitter.register

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.Response
import com.example.jwitter.RetrofitClient

interface RegisterApi {

    @POST("/users/signup")
    @Headers("Content-Type: application/json")
    suspend fun register(@Body userRegisterRequest: UserRegisterRequest): Response<UserRegisterResponse>


}

data class UserRegisterRequest(
    val email: String,
    val username: String,
    val nickname: String,
    val password: String
)

data class UserRegisterResponse(
    val access_token: String,
    val refresh_token: String
)



val userRegisterAPI : RegisterApi =
    RetrofitClient.getRetrofitClient()!!.create(RegisterApi::class.java)