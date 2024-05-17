package com.example.common.repository

import androidx.lifecycle.LiveData
import com.example.common.database.University

interface UniversityDetailsRepository {
    fun getUniversityDetails(name: String): LiveData<University>
}