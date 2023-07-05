package com.example.nitinkumar.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nitinkumar.model.Image
import com.example.nitinkumar.repository.ImageRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel(private val imageRepo: ImageRepo): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            imageRepo.getImage(1, 10)
        }
    }
    fun updateFeed(page:Int) = viewModelScope.launch(Dispatchers.IO) {
        imageRepo.getImage(page,10)
    }

    val imageList:LiveData<List<Image>>
        get() = imageRepo.imageList
}