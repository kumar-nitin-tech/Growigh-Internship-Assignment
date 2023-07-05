package com.example.nitinkumar.onBoarding

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentList: ArrayList<Fragment>,fragmentManager: FragmentManager, lifecycle:Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle){

    private val fragList = fragmentList
    override fun getItemCount(): Int {
        return fragList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragList[position]
    }
}