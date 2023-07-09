package com.example.jwitter.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jwitter.jwtToken
import kotlinx.coroutines.launch
import retrofit2.Response
import kotlin.math.log

class RegisterViewModel(private val repository: RegisterRepository): ViewModel() {
    private val _registerResponse = MutableLiveData<Response<UserRegisterResponse>>()
    val registerResponse: LiveData<Response<UserRegisterResponse>> = _registerResponse

    internal fun register(userRegisterRequest: UserRegisterRequest){
        viewModelScope.launch {
            kotlin.runCatching {
                repository.register(userRegisterRequest)
            }.onSuccess {
                Log.d("회원가입", "회원가입1")
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