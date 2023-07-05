package com.example.nitinkumar.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.nitinkumar.R

class IntroPage2Fragment : Fragment() {
    private lateinit var nextButton2:ImageView
    private lateinit var skipIntro:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_intro_page2, container, false)
        nextButton2 = view.findViewById(R.id.nextButton2)
        skipIntro = view.findViewById(R.id.skipIntroButton2)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.onBoardingPager)
        nextButton2.setOnClickListener {
            viewPager?.currentItem = 2
        }
        skipIntro.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        }
        return view
    }


}