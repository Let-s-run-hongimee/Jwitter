package com.example.jwitter.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.jwitter.R
import com.example.jwitter.base.BaseActivity
import com.example.jwitter.databinding.ActivityUserLoginBinding
import com.example.jwitter.jwtToken
import com.example.jwitter.view.Jwitterscreen

class UserLogin :BaseActivity<ActivityUserLoginBinding>(ActivityUserLoginBinding::inflate) {

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            LoginViewModelFactory(LoginRepository())
        ).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.asdasd.setOnClickListener{
            jwtlogin()
        }
    }



    fun toast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun jwtlogin(){

        if (binding.etid.text.toString().isEmpty() || binding.etpw.text.toString().isEmpty()) {
            toast("아이디와 비밀번호를 입력해주세요")
            return
        }
        else {
            viewModel.login(
                UserLoginRequest(
                    binding.etid.text.toString(),
                    binding.etpw.text.toString()
                )
            )
            Log.d("로그인", "로그인1")
            viewModel.loginResponse.observe(
                this
            ){
                if(it.isSuccessful){
                    Log.d("로그인", "로그인2")
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, Jwitterscreen::class.java))
                    finish()
                }
                else{
                    Log.d("로그인", "로그인3")
                    Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}