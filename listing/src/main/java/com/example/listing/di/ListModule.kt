package com.example.listing.di

import androidx.lifecycle.ViewModelProvider
import com.example.common.di.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelModule::class])
object ListModule {

//    @Provides
//    fun provideUniversityListViewModel(viewModel: UniversityListViewModel): UniversityListViewModel {
//        return viewModel
//    }

    @Provides
    fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory {
        return factory
    }
}