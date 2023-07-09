package com.example.jwitter.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.jwitter.base.BaseActivity
import com.example.jwitter.databinding.ActivityUserRegisterBinding
import com.example.jwitter.view.Jwitterscreen

class UserRegister : BaseActivity<ActivityUserRegisterBinding>(ActivityUserRegisterBinding::inflate) {

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            RegisterViewModelFactory(RegisterRepository())
        ).get(RegisterViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.register.setOnClickListener{
            jwtregister()
        }
    }

    fun toast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun jwtregister(){

        if (binding.etregisterid.text.toString().isEmpty() || binding.etregisterpw.text.toString().isEmpty() || binding.etregisterpwcheck.text.toString().isEmpty()) {
            toast("아이디와 비밀번호를 입력해주세요")
            return
        }
        else if (binding.etregisterpw.text.toString() != binding.etregisterpwcheck.text.toString()){
            toast("비밀번호가 일치하지 않습니다")
            return
        }
        else if (binding.etreigsternickname.text.toString().isEmpty()){
            toast("닉네임을 입력해주세요")
            return
        }
        else if (binding.etregisteremail.text.toString().isEmpty()){
            toast("이메일을 입력해주세요")
            return
        }

        else {
            viewModel.register(
                UserRegisterRequest(
                    binding.etregisteremail.text.toString(),
                    binding.etregisterid.text.toString(),
                    binding.etreigsternickname.text.toString(),
                    binding.etregisterpw.text.toString()
                )
            )
            viewModel.registerResponse.observe(
                this
            ){
                if(it.isSuccessful){
                    toast("회원가입 성공")
                    startActivity(Intent(this,Jwitterscreen::class.java))
                    finish()
                }
                else{
                    toast("회원가입 실패")
                }
            }
        }


    }
}