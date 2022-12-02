import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.test.ListUser

class MyAdapter(
    fragmentManager: FragmentManager,
    var totalTabs: Int
) :
        FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                ListUser()
            }
            1 -> {
                ListUser()
            }
            2 -> {
                ListUser()
            }
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}