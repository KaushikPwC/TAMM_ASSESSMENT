package com.example.common.repository

import androidx.lifecycle.LiveData
import com.example.common.database.University

interface UniversityRepository {
    val loadingState: LiveData<Boolean>
    fun getUniversities(): LiveData<List<University>>
    suspend fun fetchUniversities()
}