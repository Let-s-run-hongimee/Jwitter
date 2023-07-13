package com.example.jwitter.hyuntae

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jwitter.R
import com.example.jwitter.base.BaseActivity
import com.example.jwitter.databinding.ActivityProfileBinding

class profile : BaseActivity<ActivityProfileBinding>(ActivityProfileBinding::inflate) {

    private lateinit var backimg: ImageView
    private lateinit var postTextView: TextView
    private lateinit var likeTextView: TextView
    private lateinit var followersTextView: TextView

    val names = arrayOf(
        "이동건",
        "임현태",
        "이예찬",
        "홍길동",
        "이영희",
        "박지민",
        "최영수",
        "장현우",
        "정미경",
        "이승호",
        "박지원",
        "김지우",
        "한지민",
        "신동욱",
        "장서연",
        "윤영철",
        "임성민",
        "서지혜",
        "오재호",
        "최지석"
    )
    val ids = arrayOf(
        "30110",
        "30114",
        "30113",
        "홍길동",
        "이영희",
        "박지민",
        "최영수",
        "장현우",
        "정미경",
        "이승호",
        "박지원",
        "김지우",
        "한지민",
        "신동욱",
        "장서연",
        "윤영철",
        "임성민",
        "서지혜",
        "오재호",
        "최지석"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        backimg = findViewById(R.id.backbtn)
        backimg.isClickable = true


        backimg.setOnClickListener {
            onBackPressed() // 뒤로가기 동작 실행
        }

        binding.post.setOnClickListener {
            // 다른 뷰로 넘어가는 동작을 수행하기 위해 Intent를 생성합니다.
            val intent = Intent(this, profiletweet::class.java)
            startActivity(intent)
        }
        binding.ILikeIt.setOnClickListener {
            // 다른 뷰로 넘어가는 동작을 수행하기 위해 Intent를 생성합니다.
            val intent = Intent(this, i_like::class.java)
            startActivity(intent)
        }


        //1. 데이터 로딩
        val data = loadData()

        //2. 어댑터 생성
        val adapter = CustomAdapter()

        //3. 어댑터에 데이터 전달
        adapter.listData = data

        //4. 화면에 있는 리사이클러뷰에 어댑터 연결
        binding.recycler.adapter = adapter

        //5. 레이아웃 매니저 연결
        binding.recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    fun loadData() : MutableList<userData> {
        val data : MutableList<userData> = mutableListOf()

        for(no in 1..20){
            val username = names[no-1]
            val userid = "@${ids[no-1]}"

            val user = userData(username, userid)
            data.add(user)
        }
        return data
    }

}

