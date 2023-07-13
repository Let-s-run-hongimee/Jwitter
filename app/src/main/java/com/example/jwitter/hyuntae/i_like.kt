package com.example.jwitter.hyuntae

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jwitter.R
import com.example.jwitter.base.BaseActivity
import com.example.jwitter.databinding.ActivityIlikeBinding

class i_like : BaseActivity<ActivityIlikeBinding>(ActivityIlikeBinding::inflate) {

    private lateinit var backimg: ImageView
    private lateinit var postTextView: TextView
    private lateinit var followTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        backimg = findViewById(R.id.backbtn)
        backimg.isClickable = true

        postTextView = findViewById(R.id.post)
        followTextView = findViewById(R.id.follow)

        backimg.setOnClickListener {
            onBackPressed() // 뒤로가기 동작 실행
        }

        postTextView.setOnClickListener {
            // 다른 뷰로 넘어가는 동작을 수행하기 위해 Intent를 생성합니다.
            val intent = Intent(this, profiletweet::class.java)
            startActivity(intent)
        }
        followTextView.setOnClickListener {
            // 다른 뷰로 넘어가는 동작을 수행하기 위해 Intent를 생성합니다.
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }
        //1. 데이터 로딩
        val data = loadData()

        //2. 어댑터 생성
        val adapter = CustomAdapter2()

        //3. 어댑터에 데이터 전달
        adapter.listData = data

        //4. 화면에 있는 리사이클러뷰에 어댑터 연결
        binding.recycler.adapter = adapter

        //5. 레이아웃 매니저 연결
        binding.recycler.layoutManager = LinearLayoutManager(this)
    }

    fun loadData() : MutableList<postData> {
        val data : MutableList<postData> = mutableListOf()

        for(no in 1..20){
            val username = "User ${no}"
            val text = "qwerqwerqwerqwerqwer"
            val chat = 0
            val retweet = 0
            val like = 0
            val views = 0

            val post = postData(username, "@30119", text, chat, retweet, like, views)
            data.add(post)
        }
        return data
    }

}
