package com.example.jwitter.login

import retrofit2.Response

class LoginRepository {
    suspend fun login(userLoginRequest: UserLoginRequest): Response<LoginResponse> {
        return userLoginAPI.login(userLoginRequest)
    }
}
