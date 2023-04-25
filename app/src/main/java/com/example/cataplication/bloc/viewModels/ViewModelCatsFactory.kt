package com.example.cataplication.bloc.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cataplication.repositories.CatRepository

class ViewModelCatsFactory(private val catRepository: CatRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelCat(catRepository) as T
    }


}