package com.example.common.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.common.database.University
import com.example.common.database.UniversityDao
import com.example.common.network.ApiService

class UniversityRepositoryImpl(
    private val apiService: ApiService,
    private val universityDao: UniversityDao
) : UniversityRepository {

    private val _loadingState = MutableLiveData<Boolean>()
    override val loadingState: LiveData<Boolean>
        get() = _loadingState


    override fun getUniversities(): LiveData<List<University>> {
        return universityDao.getAllUniversities()
    }

    override suspend fun fetchUniversities() {
        try {
            _loadingState.value = true
            val universitiesResponse = apiService.getUniversities("United Arab Emirates")
            _loadingState.value = false
            universityDao.addUniversities(universitiesResponse)
        } catch (e: Exception) {
            _loadingState.value = false
            throw e
        }
    }
}