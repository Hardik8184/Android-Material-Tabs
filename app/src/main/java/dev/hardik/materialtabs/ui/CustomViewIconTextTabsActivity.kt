package dev.hardik.materialtabs.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
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

class CustomViewIconTextTabsActivity : AppCompatActivity() {

  private val viewPager by bindView<ViewPager>(R.id.viewpager)
  private val tabLayout by bindView<TabLayout>(R.id.tabLayout)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_custom_view_icon_text_tabs)

    setupViewPager(viewPager)

    tabLayout.setupWithViewPager(viewPager)
    setupTabIcons()
  }

  /**
   * Adding custom view to tab
   */
  @SuppressLint("InflateParams")
  private fun setupTabIcons() {

    val tabOne = LayoutInflater.from(this).inflate(R.layout.custom_tab, null) as TextView
    tabOne.text = getString(R.string.one)
    tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_favourite, 0, 0)
    tabLayout.getTabAt(0)!!.customView = tabOne

    val tabTwo = LayoutInflater.from(this).inflate(R.layout.custom_tab, null) as TextView
    tabTwo.text = getString(R.string.two)
    tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_call, 0, 0)
    tabLayout.getTabAt(1)!!.customView = tabTwo

    val tabThree = LayoutInflater.from(this).inflate(R.layout.custom_tab, null) as TextView
    tabThree.text = getString(R.string.three)
    tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_contacts, 0, 0)
    tabLayout.getTabAt(2)!!.customView = tabThree
  }

  /**
   * Adding fragments to ViewPager
   */
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
