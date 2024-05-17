package com.example.detailsmodule.di

import androidx.lifecycle.ViewModel
import com.example.common.repository.UniversityDetailsRepository
import com.example.detailsmodule.viewmodel.UniversityDetailsViewModel
import dagger.Module
import dagger.Provides

//@Module
//abstract class ViewModelModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(UniversityDetailsViewModel::class)
//    abstract fun bindUniversityDetailsViewModel(viewModel: UniversityDetailsViewModel): ViewModel
//}

@Module
object ViewModelModule {

    @Provides
    fun provideUniversityDetailsViewModel(repository: UniversityDetailsRepository): UniversityDetailsViewModel {
        return UniversityDetailsViewModel(repository)
    }

    @Provides
    fun provideViewModelMap(
        universityDetailsViewModel: UniversityDetailsViewModel
    ): Map<Class<out ViewModel>, ViewModel> {
        val viewModelMap = mutableMapOf<Class<out ViewModel>, ViewModel>()
        viewModelMap[UniversityDetailsViewModel::class.java] = universityDetailsViewModel
        return viewModelMap
    }
}