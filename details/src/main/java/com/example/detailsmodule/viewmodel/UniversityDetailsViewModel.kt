package com.example.detailsmodule.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.common.database.University
import com.example.common.repository.UniversityDetailsRepository
import javax.inject.Inject

class UniversityDetailsViewModel @Inject constructor(private val universityDetailsRepository: UniversityDetailsRepository) : ViewModel() {

    fun getUniversityDetails(name: String): LiveData<University> {
        return universityDetailsRepository.getUniversityDetails(name)
    }
}