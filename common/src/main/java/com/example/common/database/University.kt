package com.example.common.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class University(

    @PrimaryKey(autoGenerate = false)
    val name: String,

    @SerializedName("alpha_two_code") val alphaTwoCode: String,
    val country: String,
    val domains: List<String>,

    @SerializedName("state-province") val stateProvince: String?,
    @SerializedName("web_pages") val webPages: List<String>
)