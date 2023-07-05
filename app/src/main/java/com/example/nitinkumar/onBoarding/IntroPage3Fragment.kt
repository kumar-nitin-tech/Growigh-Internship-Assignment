package com.example.nitinkumar.onBoarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nitinkumar.R

class IntroPage3Fragment : Fragment() {
    private lateinit var readyButton: ImageView
    private lateinit var skipIntro: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_intro_page3, container, false)
        readyButton = view.findViewById(R.id.readyButton)
        skipIntro = view.findViewById(R.id.skipIntroButton3)

        readyButton.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        }
        skipIntro.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        }
        return view
    }


}