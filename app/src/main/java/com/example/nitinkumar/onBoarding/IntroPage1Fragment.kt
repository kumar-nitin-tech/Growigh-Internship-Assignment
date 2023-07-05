package com.example.nitinkumar.onBoarding

import android.content.Context
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

class IntroPage1Fragment : Fragment() {

    private lateinit var nextButton1:ImageView
    private lateinit var skipIntro:Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_intro_page1, container, false)
        nextButton1 = view.findViewById(R.id.nextButton1)
        skipIntro = view.findViewById(R.id.skipIntroButton)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.onBoardingPager)
        onBoardingFinish()
        nextButton1.setOnClickListener {
            viewPager?.currentItem = 1
        }
        skipIntro.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        }
        return view
    }

    private fun onBoardingFinish(){
        val prefCheck = requireActivity().getSharedPreferences("loginCheck",Context.MODE_PRIVATE)
        val check = prefCheck.getBoolean("firstLogin",false)
        if(check){
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        }
    }

}