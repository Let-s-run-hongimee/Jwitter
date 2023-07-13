package com.example.jwitter

import android.app.Application
import com.example.jwitter.view.PreferenceUtil

class MainApplication: Application()     {

    companion object {
        lateinit var prefs: PreferenceUtil
    }

    override fun onCreate() {
        super.onCreate()
        prefs = PreferenceUtil(applicationContext)
    }

}