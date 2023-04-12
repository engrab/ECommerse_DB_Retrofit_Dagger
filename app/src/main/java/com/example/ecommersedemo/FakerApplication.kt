package com.example.ecommersedemo

import android.app.Application
import com.example.ecommersedemo.di.AppComponent
import com.example.ecommersedemo.di.DaggerAppComponent

class FakerApplication : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent =  DaggerAppComponent.factory().create(this)
    }
}