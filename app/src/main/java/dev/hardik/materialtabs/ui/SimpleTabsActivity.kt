package dev.hardik.materialtabs.ui

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar

import java.util.ArrayList

import dev.hardik.materialtabs.R
import dev.hardik.materialtabs.fragments.OneFragment
import dev.hardik.materialtabs.fragments.ThreeFragment
import dev.hardik.materialtabs.fragments.TwoFragment

class SimpleTabsActivity : AppCompatActivity() {

  private val viewPager by bindView<ViewPager>(R.id.viewpager)
  private val tabLayout by bindView<TabLayout>(R.id.tabLayout)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_simple_tabs)

    setupViewPager(viewPager)
    tabLayout.setupWithViewPager(viewPager)
  }

  private fun setupViewPager(viewPager: ViewPager) {
    val adapter = ViewPagerAdapter(supportFragmentManager)
    adapter.addFragment(OneFragment(), "ONE")
    adapter.addFragment(TwoFragment(), "TWO")
    adapter.addFragment(ThreeFragment(), "THREE")
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

    fun addFragment(
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
