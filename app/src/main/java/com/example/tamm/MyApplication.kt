package com.example.tamm

import android.app.Application
import com.example.common.di.CommonModule

class MyApplication : Application() {

    companion object {
        lateinit var instance: MyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        CommonModule.setApplication(this)
    }
}