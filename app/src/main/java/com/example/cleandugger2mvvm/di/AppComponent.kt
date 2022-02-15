package com.example.cleandugger2mvvm.di

import com.example.cleandugger2mvvm.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}