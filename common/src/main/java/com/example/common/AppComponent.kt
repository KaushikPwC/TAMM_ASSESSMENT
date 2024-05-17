package com.example.common

import com.example.common.di.CommonModule
import com.example.common.repository.UniversityDetailsRepository
import com.example.common.repository.UniversityRepository
import dagger.Component

@Component(modules = [CommonModule::class])
interface CommonAppComponent {

    fun universityRepository(): UniversityRepository
    fun universityDetailsRepository(): UniversityDetailsRepository
//    fun viewModelFactory(): ViewModelProvider.Factory

}