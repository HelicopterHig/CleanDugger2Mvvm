package com.example.data.api


import com.example.data.api.model.Post
import com.example.data.api.model.Time
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/v1/bpi/currentprice.json")
    suspend fun getCustomPosts(): Response<Post>
}