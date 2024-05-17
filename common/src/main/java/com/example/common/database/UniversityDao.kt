package com.example.common.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UniversityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUniversities(universities: List<University>)

    @Query("SELECT * FROM University")
    fun getAllUniversities(): LiveData<List<University>>

    @Query("SELECT * FROM University WHERE name = :name")
    fun getUniversityByName(name: String): LiveData<University>
}