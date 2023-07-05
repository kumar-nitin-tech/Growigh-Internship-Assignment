package com.example.nitinkumar.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.nitinkumar.R
import com.google.android.material.appbar.MaterialToolbar


class UploadFragment : Fragment() {

    private lateinit var closeButton:ImageButton
    private lateinit var backButton: MaterialToolbar
    private lateinit var selectButton:Button
    private lateinit var selectedImage:ImageView
    private  var imageUri: Uri? = null
    private lateinit var uploadButton:Button

    private var contract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == AppCompatActivity.RESULT_OK){
            imageUri = it.data?.data
            selectedImage.setImageURI(imageUri)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_upload, container, false)
        allFindByViewId(view)
        closeButton.visibility = View.INVISIBLE
        selectedImage.visibility = View.INVISIBLE
        backButton.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_uploadFragment_to_homeFragment)
        }

        selectButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            contract.launch(intent)
            closeButton.visibility = View.VISIBLE
            selectedImage.visibility = View.VISIBLE
        }
        closeButton.setOnClickListener {
            if(imageUri != null){
                selectedImage.setImageDrawable(null)
            }
            closeButton.visibility = View.GONE
        }
        uploadButton.setOnClickListener {
            findNavController().navigate(R.id.action_uploadFragment_to_homeFragment)
        }
        return view
    }

    private fun allFindByViewId(view: View) {
        closeButton = view.findViewById(R.id.closeImage)
        backButton = view.findViewById(R.id.uploadTopBar)
        selectButton = view.findViewById(R.id.selectImageButton)
        selectedImage = view.findViewById(R.id.selectedImage)
        uploadButton = view.findViewById(R.id.uploadButtonClick)
    }


}