import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.jwitter.view.home_following
import com.example.jwitter.view.home_recommend

class ViewPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2 // 탭의 개수

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> home_recommend() // 추천 탭에 대한 Fragment인 home_recommend를 생성하여 반환합니다.
            1 -> home_following() // 팔로우 중인 탭에 대한 Fragment인 home_following을 생성하여 반환합니다.

            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}
