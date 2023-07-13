package com.example.jwitter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.jwitter.base.BaseActivity
import com.example.jwitter.databinding.ActivityTweetCreateBinding
import com.example.jwitter.tweet.TweetcreateRequest
import com.example.jwitter.view.tweet.TweetRepository
import com.example.jwitter.view.tweet.TweetViewModel
import com.example.jwitter.view.tweet.TweetViewModelFactory

class TweetCreate : BaseActivity<ActivityTweetCreateBinding>(ActivityTweetCreateBinding::inflate) {

    private val viewmodel by lazy {
        ViewModelProvider(
            this,
            TweetViewModelFactory(TweetRepository())
        ).get(TweetViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.tweetcreatebtn.setOnClickListener {
            TweetCreate()
        }

    }

    fun toast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun TweetCreate(){
        if(binding.Jwtcreatecontent.text.toString().isEmpty()){
            toast("내용을 입력해주세요")
            return
            }
        else{
            viewmodel.tweetCreate(
                TweetcreateRequest(
                    binding.Jwtcreatecontent.text.toString()
                )
            )
            viewmodel.tweetResponse.observe(this){
                if(it.isSuccessful){
                    toast("작성 완료")
                    finish()
                }
                else{
                    toast("작성 실패")
                }
            }
        }
    }
}