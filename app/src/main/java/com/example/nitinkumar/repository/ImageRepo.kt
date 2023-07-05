package com.example.nitinkumar.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nitinkumar.model.Image
import com.example.nitinkumar.retrofit.ImageServices

class ImageRepo(private val imageServices: ImageServices){

    private val imageLiveData = MutableLiveData<List<Image>>()
    var page = 1
    val imageList:LiveData<List<Image>>
        get() = imageLiveData

    suspend fun getImage(page: Int, limit: Int){
        val response = imageServices.getAllImage(page,limit)
        if(response.isSuccessful && response.body() != null){
            imageLiveData.postValue(response.body())
        }
    }
}