package mdk.diaryapp.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import mdk.diaryapp.R
import mdk.diaryapp.use.ToolBar
import mdk.mdapp.MainPagerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar = ToolBar()
        toolbar.setToolBar(this@MainActivity, toolBar_main)

        setNavigationView()
        setViewPager()
    }

    private fun setViewPager() {
        var pagerAdapter = MainPagerAdapter(supportFragmentManager, tabLayout_main.tabCount)
        viewPager_main.adapter = pagerAdapter
        viewPager_main.addOnPageChangeListener(
                TabLayout.TabLayoutOnPageChangeListener(
                        tabLayout_main
                )
        )

        tabLayout_main.setTabTextColors(
                Color.parseColor("#000000"),
                Color.parseColor("#2196F3")
        )
        tabLayout_main.addOnTabSelectedListener(object :
                TabLayout.BaseOnTabSelectedListener<TabLayout.Tab> {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                viewPager_main.currentItem = p0!!.position
                if (p0.position == 0) { // Của bạn
                    /*tabLayout_main.setTabTextColors(
                            Color.parseColor("#000000"),
                            Color.parseColor("#2196F3")
                    )*/
                    Toast.makeText(this@MainActivity, "0", Toast.LENGTH_SHORT).show()
                } else if (p0.position == 1) { // TimeLine
                    Toast.makeText(this@MainActivity, "1", Toast.LENGTH_SHORT).show()
                } else if (p0.position == 2) { // Nổi bật
                    Toast.makeText(this@MainActivity, "2", Toast.LENGTH_SHORT).show()
                } else if (p0.position == 3) { // HashTag
                    Toast.makeText(this@MainActivity, "3", Toast.LENGTH_SHORT).show()
                } else if (p0.position == 4) { // Lưu lại
                    Toast.makeText(this@MainActivity, "4", Toast.LENGTH_SHORT).show()
                } else { // Sống
                    /*tabLayout_main.setTabTextColors(
                            Color.parseColor("#000000"),
                            Color.parseColor("#F39C12")
                    )*/
                    Toast.makeText(this@MainActivity, "5", Toast.LENGTH_SHORT).show()
                }
            }

        })

        tabLayout_main.tabTextColors
        viewPager_main.offscreenPageLimit = 6
    }

    private fun setNavigationView() {
        var toggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout_main, toolBar_main,
        R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        drawerLayout_main.addDrawerListener(toggle)
        toggle.syncState()
        toggle.drawerArrowDrawable.color = Color.parseColor("#FFFFFF")

        navigationView_main.setNavigationItemSelectedListener(object : NavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.nav_nangCap -> {
                        Toast.makeText(this@MainActivity, "0", Toast.LENGTH_SHORT).show()
                    }
                    R.id.nav_trangCaNhan -> {
                        Toast.makeText(this@MainActivity, "1", Toast.LENGTH_SHORT).show()
                    }
                    R.id.nav_chuDe -> {
                        Toast.makeText(this@MainActivity, "2", Toast.LENGTH_SHORT).show()
                    }
                    R.id.nav_fontChu -> {
                        Toast.makeText(this@MainActivity, "3", Toast.LENGTH_SHORT).show()
                    }
                    R.id.nav_danhGia -> {
                        Toast.makeText(this@MainActivity, "4", Toast.LENGTH_SHORT).show()
                    }
                    R.id.nav_chiaSe -> {
                        Toast.makeText(this@MainActivity, "5", Toast.LENGTH_SHORT).show()
                    }
                    R.id.nav_guidLine -> {
                        Toast.makeText(this@MainActivity, "6", Toast.LENGTH_SHORT).show()
                    }
                    R.id.nav_dangXuat -> {
                        Toast.makeText(this@MainActivity, "7", Toast.LENGTH_SHORT).show()
                    }
                }
                drawerLayout_main.closeDrawer(GravityCompat.START)
                return true
            }
        })
    }
}