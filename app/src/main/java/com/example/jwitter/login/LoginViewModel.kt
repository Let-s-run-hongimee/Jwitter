package com.example.jwitter.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.jwitter.jwtToken
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {
    private val _loginResponse = MutableLiveData<Response<LoginResponse>>()
    val loginResponse: LiveData<Response<LoginResponse>> = _loginResponse


    internal fun login(userLoginRequest: UserLoginRequest) {
        viewModelScope.launch {
           kotlin.runCatching {
               repository.login(userLoginRequest)
           }.onSuccess {
               _loginResponse.postValue(it)
               if(it.isSuccessful){
                   with(jwtToken){
                       accesstoken = it.body()?.access_token.also { tk ->
                           println(tk)
                       }
                       refreshtoken = it.body()?.refresh_token.also { tk ->
                           println(tk)
                       }
                   }
               }
           }.onFailure {
               println("Failure.. &it")
           }
    }
}
}