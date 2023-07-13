package com.example.jwitter.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jwitter.databinding.ActivityMainBinding
import com.example.jwitter.login.UserLogin
import com.example.jwitter.register.UserRegister

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.start.setOnClickListener{
            val intent = Intent(this, UserRegister::class.java)
            startActivity(intent)
        }

        binding.gotologin.setOnClickListener{
            val intent = Intent(this, UserLogin::class.java)
            startActivity(intent)
        }

    }


}