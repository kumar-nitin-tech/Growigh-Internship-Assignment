package com.example.nitinkumar.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nitinkumar.repository.ImageRepo

class MainViewModelFactory(private val imageRepo: ImageRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(imageRepo) as T
    }
}