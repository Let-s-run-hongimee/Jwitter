package com.example.jwitter

import ViewPagerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.jwitter.databinding.FragmentMainMenuHomeBinding
import android.graphics.Typeface
import android.view.Gravity
import android.widget.TextView
import com.example.jwitter.databinding.CustomTabItemBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainMenuHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainMenuHomeFragment : Fragment() {

    private lateinit var binding: FragmentMainMenuHomeBinding
    private lateinit var viewPager: ViewPager2

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainMenuHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        viewPager = binding.viewPager

        val tabLayout: TabLayout = binding.tabs

        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        val tabTitles = arrayOf("추천", "팔로우 중")

        val tabLayoutMediator = TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val tabView = LayoutInflater.from(requireContext()).inflate(R.layout.custom_tab_item, tabLayout, false)
            val tabTitle = tabView.findViewById<TextView>(R.id.tab_title)
            tabTitle.text = tabTitles[position]
            tab.customView = tabView
        }
        tabLayoutMediator.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val tabView = tab?.customView?.findViewById<TextView>(R.id.tab_title)
                tabView?.typeface = Typeface.DEFAULT_BOLD
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val tabView = tab?.customView?.findViewById<TextView>(R.id.tab_title)
                tabView?.typeface = Typeface.DEFAULT
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Do nothing
            }
        })

        return view
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainMenuHomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainMenuHomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}