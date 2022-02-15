package com.example.cleandugger2mvvm

import android.app.Application
import com.example.cleandugger2mvvm.di.AppComponent
import com.example.cleandugger2mvvm.di.AppModule
import com.example.cleandugger2mvvm.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }

}