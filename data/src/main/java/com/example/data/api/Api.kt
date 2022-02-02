package com.example.data.api


import com.example.data.api.model.Post
import retrofit2.http.GET

interface Api {


    @GET("/v1/bpi/currentprice.json")
    suspend fun getPost(): Post
}