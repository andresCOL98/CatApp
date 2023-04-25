package com.example.cataplication.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatApiUtilities {

    val BSE_URL = "https://api.thecatapi.com/v1/"


    fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BSE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}