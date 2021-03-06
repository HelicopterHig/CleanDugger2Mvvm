package com.example.data.api


import com.example.domain.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("/v1/bpi/currentprice.json")
    suspend fun getCustomPosts(): Response<Post>
}