import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.jwitter.view.home_following
import com.example.jwitter.view.home_recommend

/**
 * ViewPagerAdapter는 ViewPager2와 함께 사용되는 FragmentStateAdapter의 하위 클래스입니다.
 * 주어진 위치에 해당하는 Fragment를 생성하고 반환합니다.
 */
public class ViewPagerAdapter(
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
