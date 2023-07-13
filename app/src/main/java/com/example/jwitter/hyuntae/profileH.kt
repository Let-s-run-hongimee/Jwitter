package com.example.jwitter.hyuntae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import com.example.jwitter.R

class profileH : AppCompatActivity() {
    private lateinit var closebutton: Button
    private lateinit var followbutton: AppCompatButton
    private lateinit var layoutToHide: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item)

        closebutton = findViewById(R.id.closebtn)
        layoutToHide = findViewById(R.id.layoutToHide)
        followbutton = findViewById(R.id.followbtn)

        closebutton.setOnClickListener {
            layoutToHide.visibility = View.GONE
        }
        followbutton.setOnClickListener {
            followbutton.isEnabled = false
        }
    }
}