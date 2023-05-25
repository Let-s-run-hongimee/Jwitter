import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.jwitter.home_following
import com.example.jwitter.home_recommend

public class ViewPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2 // 탭 개수

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> home_recommend()
            1 -> home_following()

            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}
