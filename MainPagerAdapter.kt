package mdk.mdapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import mdk.mdapp.fragment.*

class MainPagerAdapter(fm: FragmentManager?, numOfTabs: Int) : FragmentPagerAdapter(fm!!) {

    var numOfTabs: Int = 0

    init {
        this.numOfTabs = numOfTabs
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return CuaBanFragment()
            1 -> return TimeLineFragment()
            2 -> return NoiBatFragment()
            3 -> return HashTagFragment()
            4 -> return LuuLaiFragment()
            5 -> return SongFragment()
            else -> return CuaBanFragment()
        }
    }

    override fun getCount(): Int {
        return numOfTabs
    }
}