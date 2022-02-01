package com.example.cleandugger2mvvm.api

import com.example.cleandugger2mvvm.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Instance {


    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : Api by lazy {
        retrofit.create(Api::class.java)
    }
}