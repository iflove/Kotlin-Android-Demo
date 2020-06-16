package com.example.lazy.kotlin.douban.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.lazy.kotlin.R
import com.example.lazy.kotlin.douban.base.BaseActivity
import com.example.lazy.kotlin.douban.movie.MovieFragment
import com.example.lazy.kotlin.douban.movie.MusicFragment
import com.example.lazy.kotlin.module.utils.ResUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    val titleTabsArray: Array<String> = ResUtil.getStringArray(R.array.title_tabs)

    val fragments = listOf<Fragment>(MovieFragment(), MusicFragment())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setupViews() {
        super.setupViews()
        setSupportActionBar(toolbar);
        viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {

            override fun getItem(position: Int): Fragment = fragments.get(position)

            override fun getCount(): Int = titleTabsArray.size

            override fun getPageTitle(position: Int): CharSequence = titleTabsArray.get(position)
        }
        tabs.setupWithViewPager(viewPager)
        viewPager.currentItem = 0
    }

    override fun setViewListener() {
        super.setViewListener()
    }

    override fun onResume() {
        super.onResume()
    }
}
