package com.example.listing.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.database.University
import com.example.common.repository.UniversityRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class UniversityListViewModel @Inject constructor(private val universityRepository: UniversityRepository) :
    ViewModel() {

    val loadingState: LiveData<Boolean> = universityRepository.loadingState

    //loading DB data by default
    val universities: LiveData<List<University>> = universityRepository.getUniversities()

    fun fetchUniversities(isAPICallRequired: Boolean) {
        viewModelScope.launch {
            if(isAPICallRequired){
                universityRepository.fetchUniversities()
            }
        }
    }
}