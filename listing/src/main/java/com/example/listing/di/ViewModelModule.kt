package com.example.listing.di

import androidx.lifecycle.ViewModel
import com.example.common.repository.UniversityRepository
import com.example.listing.viewmodel.UniversityListViewModel
import dagger.Module
import dagger.Provides

//@Module
//abstract class ViewModelModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(UniversityListViewModel::class)
//    abstract fun bindUniversityListViewModel(viewModel: UniversityListViewModel): ViewModel
//}

@Module
object ViewModelModule {

    @Provides
    fun provideUniversityListViewModel(repository: UniversityRepository): UniversityListViewModel {
        return UniversityListViewModel(repository)
    }

    @Provides
    fun provideViewModelMap(
        universityListViewModel: UniversityListViewModel
    ): Map<Class<out ViewModel>, ViewModel> {
        val viewModelMap = mutableMapOf<Class<out ViewModel>, ViewModel>()
        viewModelMap[UniversityListViewModel::class.java] = universityListViewModel
        return viewModelMap
    }
}