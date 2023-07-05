package com.example.nitinkumar.fragment

import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.nitinkumar.Adapter.RecyclerViewAdapter
import com.example.nitinkumar.R
import com.example.nitinkumar.repository.ImageRepo
import com.example.nitinkumar.retrofit.RetrofitInstance
import com.example.nitinkumar.viewModel.MainViewModel
import com.example.nitinkumar.viewModel.MainViewModelFactory
import com.google.android.material.imageview.ShapeableImageView

class FeedFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var profile:ShapeableImageView
    private  var profileUri: Uri? = null
    private lateinit var  imageUri:String

    private val contract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
       if(it.resultCode == AppCompatActivity.RESULT_OK){
           profileUri = it.data?.data
           profile.setImageURI(profileUri)
           activity?.contentResolver?.takePersistableUriPermission(profileUri!!, Intent.FLAG_GRANT_READ_URI_PERMISSION)
           val persist = activity?.getSharedPreferences("image",Context.MODE_PRIVATE)?.edit()
           persist?.putString("imageUri", profileUri.toString())
           persist?.apply()
       }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_feed, container, false)
        allFindByViewId(view)
        profileUpdate()
        val imageServices = RetrofitInstance.getInstance
        val imageRepo = ImageRepo(imageServices)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(imageRepo))[MainViewModel::class.java]


        swipeRefreshLayout.setOnRefreshListener {
            val pageNumber = (1..50).random()
            mainViewModel.updateFeed(pageNumber)
            swipeRefreshLayout.isRefreshing = false
        }

        recyclerViewUpdate()
        return view
    }

    private fun profileUpdate() {
        imageUri = arguments?.getString("uri").toString()
        if(imageUri == "null"){
            profile.setImageResource(R.drawable.profile)
        }else{
            profile.setImageURI(imageUri.toUri())
        }
        profile.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            contract.launch(intent)
        }
    }

    private fun allFindByViewId(view: View) {
        recyclerView = view.findViewById(R.id.feedRecyclerView)
        swipeRefreshLayout = view.findViewById(R.id.refreshSwipe)
        profile = view.findViewById(R.id.profile)
    }

    private fun recyclerViewUpdate(){
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter

        mainViewModel.imageList.observe(viewLifecycleOwner) {list->
            list.let {
                adapter.setImage(it)
            }
        }
    }



}