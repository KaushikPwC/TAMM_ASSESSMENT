package com.example.common.di

import android.app.Application
import androidx.room.Room
import com.example.common.database.AppDatabase
import com.example.common.database.UniversityDao
import com.example.common.network.ApiService
import com.example.common.network.RetrofitInstance
import com.example.common.repository.UniversityDetailsRepository
import com.example.common.repository.UniversityDetailsRepositoryImpl
import com.example.common.repository.UniversityRepository
import com.example.common.repository.UniversityRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
object CommonModule {

    private lateinit var application: Application

    @JvmStatic
    @Provides
    fun provideApplication(): Application {
        if (!::application.isInitialized) {
            throw IllegalStateException("Application has not been initialized in CommonModule")
        }
        return application
    }

    fun setApplication(app: Application) {
        application = app
    }


    @Provides
    fun provideApiService(): ApiService {
        return RetrofitInstance.apiService
    }

    @Provides
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "UniversityDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideUniversityDao(appDatabase: AppDatabase): UniversityDao {
        return appDatabase.getUniversityDao()
    }

    @Provides
    fun provideUniversityRepository(apiService: ApiService, universityDao: UniversityDao): UniversityRepository {
        return UniversityRepositoryImpl(apiService, universityDao)
    }

    @Provides
    fun provideUniversityDetailsRepository(universityDao: UniversityDao): UniversityDetailsRepository {
        return UniversityDetailsRepositoryImpl(universityDao)
    }
}