package com.example.jwitter.hyuntae

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jwitter.R
import com.example.jwitter.base.BaseActivity
import com.example.jwitter.databinding.ActivityProfiletweetBinding
import com.example.jwitter.databinding.ActivityTweetBinding

class profiletweet : BaseActivity<ActivityProfiletweetBinding>(ActivityProfiletweetBinding::inflate) {

    private lateinit var backimg: ImageView
    private lateinit var followTextView: TextView
    private lateinit var likeTextView: TextView

    val texts = arrayOf(
        "안녕하세요! 오늘은 기분 좋은 하루네요.",
        "새로운 프로젝트에 도전 중입니다!",
        "맛있는 점심을 먹었어요.",
        "오늘은 날씨가 좋네요. 산책하기 좋은 날이에요.",
        "공부를 열심히 하고 있어요.",
        "커피 한 잔 마시면서 책을 읽는 시간이 제일 좋아요.",
        "친구들과 함께 영화를 보러 갔어요.",
        "운동을 하고 스트레스를 해소했어요.",
        "요리를 해봤는데 맛있게 나왔어요.",
        "오랜만에 가족들과 함께 모여서 시간을 보냈어요.",
        "휴식이 필요한 날이에요. 쉬는 중입니다.",
        "음악을 들으면서 작업을 하니 집중력이 올라갑니다.",
        "봄날의 햇살이 참 예쁘네요.",
        "이번 주말에 여행 계획을 세워봐야겠어요.",
        "새로운 언어를 배워보려고 도전 중입니다.",
        "오늘은 특별한 날이네요. 기념일이에요.",
        "하루종일 코딩을 하느라 눈이 아프네요. 휴식이 필요해요.",
        "동호회 모임을 가졌어요. 즐거운 시간이었습니다.",
        "무엇을 해도 재미있는 날이에요.",
        "오늘도 열심히 일해야지!",
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        backimg = findViewById(R.id.backbtn)
        backimg.isClickable = true

        followTextView = findViewById(R.id.follow)
        likeTextView = findViewById(R.id.I_like_it)

        backimg.setOnClickListener {
            onBackPressed() // 뒤로가기 동작 실행
        }

        followTextView.setOnClickListener {
            // 다른 뷰로 넘어가는 동작을 수행하기 위해 Intent를 생성합니다.
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }
        likeTextView.setOnClickListener {
            // 다른 뷰로 넘어가는 동작을 수행하기 위해 Intent를 생성합니다.
            val intent = Intent(this, i_like::class.java)
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
            val username = "홍민기"
            val text = texts[no-1]
            val chat = 0
            val retweet = 0
            val like = 0
            val views = 1

            val post = postData(username, "@30119", text, chat, retweet, like, views)
            data.add(post)
        }
        return data
    }

}
