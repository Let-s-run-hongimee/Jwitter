package com.example.jwitter.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jwitter.jwtToken
import kotlinx.coroutines.launch
import retrofit2.Response
import com.example.jwitter.register.registerRepository

class registerViewModel(private val repository: registerRepository): ViewModel() {
    private val _registerResponse = MutableLiveData<Response<registerResponse>>()
    val registerResponse: LiveData<Response<registerResponse>> = _registerResponse

    internal fun register(userRegisterRequest: UserRegisterRequest){
        viewModelScope.launch {
            kotlin.runCatching {
                repository.register(userRegisterRequest)
            }.onSuccess {
                _registerResponse.postValue(it)
                if (it.isSuccessful){
                    with(jwtToken){
                        accesstoken = it.body()?.access_token.also { tk ->
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