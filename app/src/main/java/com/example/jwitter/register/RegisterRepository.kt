package com.example.jwitter.register

import retrofit2.Response

class RegisterRepository {

    suspend fun register(userRegisterRequest: UserRegisterRequest): Response<UserRegisterResponse> {
        return userRegisterAPI.register(userRegisterRequest)
    }
}