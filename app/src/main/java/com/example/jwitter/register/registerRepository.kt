package com.example.jwitter.register

import retrofit2.Response

class registerRepository {

    suspend fun register(userRegisterRequest: UserRegisterRequest): Response<registerResponse> {
        return userRegisterAPI.register(userRegisterRequest)
    }
}