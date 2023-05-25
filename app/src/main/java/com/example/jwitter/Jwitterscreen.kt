package com.example.jwitter

import com.example.jwitter.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.jwitter.databinding.ActivityJwitterscreenBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class Jwitterscreen : AppCompatActivity() {

    private lateinit var binding: ActivityJwitterscreenBinding
    private lateinit var fragment_home: Fragment
    private lateinit var fragment_search: Fragment
    private lateinit var fragment_alarm: Fragment
    private lateinit var fragment_ms: Fragment

    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityJwitterscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottomNavigationView = binding.menuBottomNavigation


        fragment_home = MainMenuHomeFragment();
        fragment_search = MainMenusearchFragment();
        fragment_alarm = MainMenualarmFragment();
        fragment_ms = MainMenuMsFragment();

        bottomNavigationView?.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home-> {
                    // 아이템 1 클릭 시 동작
                    supportFragmentManager.beginTransaction().replace(R.id.menu_frame_layout,fragment_home).commitAllowingStateLoss()
                    true
                }
                R.id.menu_search -> {
                    // 아이템 2 클릭 시 동작
                    supportFragmentManager.beginTransaction().replace(R.id.menu_frame_layout,fragment_search).commitAllowingStateLoss()
                    true
                }
                R.id.menu_alarm -> {
                    // 아이템 3 클릭 시 동작
                    supportFragmentManager.beginTransaction().replace(R.id.menu_frame_layout,fragment_alarm).commitAllowingStateLoss()
                    true
                }
                R.id.menu_ms -> {
                    // 아이템 4 클릭 시 동작
                    supportFragmentManager.beginTransaction().replace(R.id.menu_frame_layout,fragment_ms).commitAllowingStateLoss()
                    true
                }

                else -> false
            }
        }
    }
}
