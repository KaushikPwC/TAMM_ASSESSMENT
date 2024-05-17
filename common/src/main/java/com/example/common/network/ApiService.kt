package com.example.common.network

import com.example.common.database.University
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    suspend fun getUniversities(@Query("country") country: String): List<University>
}