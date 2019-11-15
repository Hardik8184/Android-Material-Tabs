package dev.hardik.materialtabs.ui

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import java.util.ArrayList

import dev.hardik.materialtabs.R
import dev.hardik.materialtabs.fragments.OneFragment
import dev.hardik.materialtabs.fragments.ThreeFragment
import dev.hardik.materialtabs.fragments.TwoFragment

class IconTabsActivity : AppCompatActivity() {

  private val viewPager by bindView<ViewPager>(R.id.viewpager)
  private val tabLayout by bindView<TabLayout>(R.id.tabLayout)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_icon_tabs)

    setupViewPager(viewPager)

    tabLayout.setupWithViewPager(viewPager)
    setupTabIcons()
  }

  private fun setupTabIcons() {
    val tabIcons =
      intArrayOf(R.drawable.ic_tab_favourite, R.drawable.ic_tab_call, R.drawable.ic_tab_contacts)

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

      // return null to display only the icon
      return null
    }
  }
}
