package com.example.cleandugger2mvvm.api

import com.example.cleandugger2mvvm.model.Post
import retrofit2.http.GET

interface Api {


    @GET("/v1/bpi/currentprice.json")
    suspend fun getPost(): Post
}