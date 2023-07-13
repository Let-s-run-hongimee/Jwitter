package com.example.jwitter.view

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jwitter.R
import com.example.jwitter.RetrofitApi
import com.example.jwitter.databinding.FragmentHomeRecommendBinding
import com.example.jwitter.hyuntae.tweet
import com.example.jwitter.jwtToken
import com.example.jwitter.view.tweet.Tweets
import com.example.jwitter.view.tweet.foryouAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.stream.IntStream.range

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class home_recommend() : Fragment(), Parcelable {
    private var _binding: FragmentHomeRecommendBinding? = null
    private val responseTweets: Tweets? = null
    private val binding get() = _binding!!

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeRecommendBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<home_recommend> {
        override fun createFromParcel(parcel: Parcel): home_recommend {
            return home_recommend(parcel)
        }

        override fun newArray(size: Int): Array<home_recommend?> {
            return arrayOfNulls(size)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val service = RetrofitApi.foryouService

        CoroutineScope(Dispatchers.IO).launch {
            val response = service.foryou()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val data:MutableList<Tweets> = mutableListOf()
                    for (i in range(0, response.body()?.tweets?.size!!)) {

                        val tweet_id = response.body()?.tweets?.get(i)?.tweet_id
                        val user_id = response.body()?.tweets?.get(i)?.user_id
                        val nickname = response.body()?.tweets?.get(i)?.nickname
                        val username = response.body()?.tweets?.get(i)?.username
                        val content = response.body()?.tweets?.get(i)?.content
                        val hearts = response.body()?.tweets?.get(i)?.hearts
                        val retweets = response.body()?.tweets?.get(i)?.retweets
                        var tweet = Tweets(tweet_id, user_id, nickname, username, content, hearts, retweets)
                        data.add(tweet)

                    }
                    var adapter = foryouAdapter()
                    adapter.listData = data
                    binding.recommendrecyclerView.adapter = adapter
                    binding.recommendrecyclerView.layoutManager = LinearLayoutManager(requireContext())

                }
                }
            }


        }


        fun loadData(tweets: List<Tweets>): MutableList<Tweets> {
            val data: MutableList<Tweets> = mutableListOf()

            for (tweet in tweets) {
                val tweet_id = tweet.tweet_id
                val user_id = tweet.user_id
                val nickname = tweet.nickname
                val username = tweet.username
                val content = tweet.content
                val hearts = tweet.hearts
                val retweets = tweet.retweets

                val post = Tweets(tweet_id, user_id, nickname, username, content, hearts, retweets)
                data.add(post)
            }

            return data
        }

        fun newInstance(param1: String, param2: String) =
            home_recommend().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
