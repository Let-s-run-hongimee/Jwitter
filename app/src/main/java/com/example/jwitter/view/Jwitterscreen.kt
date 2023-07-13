package com.example.jwitter.view

import MainMenuHomeFragment
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

        //프래그먼트 변수선언
        fragment_home = MainMenuHomeFragment()
        fragment_search = MainMenusearchFragment()
        fragment_alarm = MainMenualarmFragment()
        fragment_ms = MainMenuMsFragment()

        //프래그먼트의 아이템 클릭시 화면 전환
        bottomNavigationView?.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    // 아이템 1 클릭 시 동작
                    val currentFragment = supportFragmentManager.findFragmentById(R.id.menu_frame_layout)
                    if (currentFragment !is MainMenuHomeFragment) {
                        val newFragmentHome = MainMenuHomeFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.menu_frame_layout, newFragmentHome)
                            .addToBackStack(null)
                            .commitAllowingStateLoss()

                    }
                    true
                }
                R.id.menu_search -> {
                    // 아이템 2 클릭 시 동작
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.menu_frame_layout, fragment_search)
                        .addToBackStack(null)
                        .commitAllowingStateLoss()
                    true
                }
                R.id.menu_alarm -> {
                    // 아이템 3 클릭 시 동작
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.menu_frame_layout, fragment_alarm)
                        .addToBackStack(null)
                        .commitAllowingStateLoss()
                    true
                }
                R.id.menu_ms -> {
                    // 아이템 4 클릭 시 동작
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.menu_frame_layout, fragment_ms)
                        .addToBackStack(null)
                        .commitAllowingStateLoss()
                    true
                }
                else -> false
            }
        }

        bottomNavigationView?.selectedItemId = R.id.menu_home
    }
}
