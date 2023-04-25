package com.example.cataplication.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cataplication.models.Cat
import com.example.cataplication.services.CatApiService
import retrofit2.Response
import retrofit2.Retrofit

class CatRepository(private val catApiService:CatApiService) {
    private val apiKey = "bda53789-d59e-46cd-9bc4-2936630fde39"
    private val catsLiveData = MutableLiveData<List<Cat>>()

    val cats : LiveData<List<Cat>>
    get() = catsLiveData

    suspend fun getCats() {
        val result = catApiService.getCats(apiKey)
        if (result.body() != null){
            catsLiveData.postValue(result.body())
        }
    }
}
