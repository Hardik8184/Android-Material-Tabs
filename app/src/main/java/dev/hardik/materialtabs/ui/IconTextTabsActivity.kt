package dev.hardik.materialtabs.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import dev.hardik.materialtabs.R
import dev.hardik.materialtabs.fragments.OneFragment
import dev.hardik.materialtabs.fragments.ThreeFragment
import dev.hardik.materialtabs.fragments.TwoFragment
import java.util.ArrayList

class IconTextTabsActivity : AppCompatActivity() {

  private val viewPager by bindView<ViewPager>(R.id.viewpager)
  private val tabLayout by bindView<TabLayout>(R.id.tabLayout)

  private val tabIcons =
    intArrayOf(R.drawable.ic_tab_favourite, R.drawable.ic_tab_call, R.drawable.ic_tab_contacts)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_icon_text_tabs)

    setupViewPager(viewPager)

    tabLayout.setupWithViewPager(viewPager)
    setupTabIcons()
  }

  private fun setupTabIcons() {
    tabLayout.getTabAt(0)!!.setIcon(tabIcons[0])
    tabLayout.getTabAt(1)!!.setIcon(tabIcons[1])
    tabLayout.getTabAt(2)!!.setIcon(tabIcons[2])
  }

  private fun setupViewPager(viewPager: ViewPager) {
    val adapter = ViewPagerAdapter(supportFragmentManager)
    adapter.addFrag(OneFragment(), "ONE")
    adapter.addFrag(TwoFragment(), "TWO")
    adapter.addFrag(ThreeFragment(), "THREE")
    viewPager.adapter = adapter
  }

  internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
      return mFragmentList[position]
    }

    override fun getCount(): Int {
      return mFragmentList.size
    }

    fun addFrag(
      fragment: Fragment,
      title: String
    ) {
      mFragmentList.add(fragment)
      mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
      return mFragmentTitleList[position]
    }
  }
}
