package com.example.nitinkumar.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.nitinkumar.R
import java.nio.BufferUnderflowException

class HomeFragment : Fragment() {
    private lateinit var feedButton:Button
    private lateinit var uploadButton: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        onBoardingCheck()
        allFindByViewId(view)

        feedButton.setOnClickListener {
            val getUri = requireActivity().getSharedPreferences("image", AppCompatActivity.MODE_PRIVATE)
            val uri = getUri.getString("imageUri",null)
            val bundle = Bundle()
            bundle.putString("uri", uri)
            findNavController().navigate(R.id.action_homeFragment_to_feedFragment,bundle)
        }

        uploadButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_uploadFragment)
        }

        return view
    }

    private fun onBoardingCheck(){
        val prefCheck = requireActivity().getSharedPreferences("loginCheck",Context.MODE_PRIVATE).edit()
        prefCheck.putBoolean("firstLogin",true)
        prefCheck.apply()
    }

    private fun allFindByViewId(view: View) {
        feedButton = view.findViewById(R.id.feedButton)
        uploadButton = view.findViewById(R.id.uploadButton)
    }


}