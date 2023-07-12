import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.jwitter.R
import com.example.jwitter.databinding.FragmentMainMenuHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainMenuHomeFragment : Fragment() {

    private var _binding: FragmentMainMenuHomeBinding? = null
    private var param1: String? = null
    private var param2: String? = null
    private val binding get() = _binding!!

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
        _binding = FragmentMainMenuHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        val viewPager: ViewPager2 = binding.viewPager
        val tabLayout: TabLayout = binding.tabs

        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        val tabTitles = arrayOf("추천", "팔로우 중")

        val tabLayoutMediator = TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val tabView = LayoutInflater.from(requireContext())
                .inflate(R.layout.custom_tab_item, tabLayout, false)
            val tabTitle = tabView.findViewById<TextView>(R.id.tab_title)
            tabTitle.text = tabTitles[position]
            tab.customView = tabView
        }
        tabLayoutMediator.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val tabView = tab?.customView
                val tabTitle = tabView?.findViewById<TextView>(R.id.tab_title)
                tabTitle?.let {
                    it.setTypeface(null, Typeface.BOLD)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val tabView = tab?.customView
                val tabTitle = tabView?.findViewById<TextView>(R.id.tab_title)
                tabTitle?.let {
                    it.setTypeface(null, Typeface.NORMAL)
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Do nothing
            }
        })

        return view
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
