package com.example.detailsmodule.di

import androidx.lifecycle.ViewModelProvider
import com.example.common.di.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelModule::class])
object DetailsModule {

//    @Provides
//    fun provideUniversityDetailsViewModel(viewModel: UniversityDetailsViewModel): UniversityDetailsViewModel {
//        return viewModel
//    }

    @Provides
    fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory {
        return factory
    }
}