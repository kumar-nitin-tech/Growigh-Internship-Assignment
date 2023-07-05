package com.example.nitinkumar.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.nitinkumar.R

class ViewPagerFragment : Fragment() {
    private lateinit var viewPager:ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        viewPager = view.findViewById(R.id.onBoardingPager)
        val fragmentList = arrayListOf(
            IntroPage1Fragment(),
            IntroPage2Fragment(),
            IntroPage3Fragment()
        )
        val adapter = ViewPagerAdapter(fragmentList, childFragmentManager , lifecycle)
        viewPager.adapter = adapter

        return view
    }



}