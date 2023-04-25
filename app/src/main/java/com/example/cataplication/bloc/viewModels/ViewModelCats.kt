package com.example.cataplication.bloc.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cataplication.models.Cat
import com.example.cataplication.repositories.CatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelCat(private val repository : CatRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCats()
        }
    }

    val cats : LiveData<List<Cat>>
    get() = repository.cats


}