package dev.hardik.materialtabs.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton

import dev.hardik.materialtabs.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

  private val btnSimpleTabs by bindView<AppCompatButton>(R.id.btnSimpleTabs)
  private val btnScrollableTabs by bindView<AppCompatButton>(R.id.btnScrollableTabs)
  private val btnIconTextTabs by bindView<AppCompatButton>(R.id.btnIconTextTabs)
  private val btnIconTabs by bindView<AppCompatButton>(R.id.btnIconTabs)
  private val btnCustomIconTabs by bindView<AppCompatButton>(R.id.btnCustomIconTabs)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    btnSimpleTabs.setOnClickListener(this)
    btnScrollableTabs.setOnClickListener(this)
    btnIconTextTabs.setOnClickListener(this)
    btnIconTabs.setOnClickListener(this)
    btnCustomIconTabs.setOnClickListener(this)
  }

  override fun onClick(view: View) {
    when (view.id) {
      R.id.btnSimpleTabs -> startActivity(Intent(this@MainActivity, SimpleTabsActivity::class.java))
      R.id.btnScrollableTabs -> startActivity(
          Intent(this@MainActivity, ScrollableTabsActivity::class.java)
      )
      R.id.btnIconTextTabs -> startActivity(
          Intent(this@MainActivity, IconTextTabsActivity::class.java)
      )
      R.id.btnIconTabs -> startActivity(Intent(this@MainActivity, IconTabsActivity::class.java))
      R.id.btnCustomIconTabs -> startActivity(
          Intent(this@MainActivity, CustomViewIconTextTabsActivity::class.java)
      )
    }
  }
}
