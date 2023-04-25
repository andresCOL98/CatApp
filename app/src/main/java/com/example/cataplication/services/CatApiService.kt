package com.example.cataplication.services

import com.example.cataplication.models.Cat
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface CatApiService {

    @GET("breeds")
    suspend fun getCats(@Header("x-api-key") apiKey: String): Response<List<Cat>>
}