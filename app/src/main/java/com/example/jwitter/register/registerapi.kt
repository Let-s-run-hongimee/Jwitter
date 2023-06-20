package com.example.jwitter.register

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.Response
import com.example.jwitter.RetrofitClient

interface RegisterApi {

    @POST("/user/signup")
    @Headers("Content-Type: application/json")
    suspend fun register(@Body userRegisterRequest: UserRegisterRequest): Response<registerResponse>


}

data class UserRegisterRequest(
    val username: String,
    val email: String,
    val password: String,
)

data class registerResponse(
    val access_token: String,
    val refresh_token: String
)



val userRegisterAPI : RegisterApi =
    RetrofitClient.getRetrofitClient()!!.create(RegisterApi::class.java)