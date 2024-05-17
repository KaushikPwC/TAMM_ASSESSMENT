package com.example.common.repository

import androidx.lifecycle.LiveData
import com.example.common.database.University
import com.example.common.database.UniversityDao

class UniversityDetailsRepositoryImpl(private val universityDao: UniversityDao) :
    UniversityDetailsRepository {

    override fun getUniversityDetails(name: String): LiveData<University> {
        return universityDao.getUniversityByName(name)
    }
}