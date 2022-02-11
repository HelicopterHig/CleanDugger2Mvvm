package com.example.data.repository

import com.example.data.api.Instance
import com.example.data.api.model.Bpi
import com.example.data.api.model.Post
import com.example.data.api.model.Time
import retrofit2.Response

class Repository {




    suspend fun getCustomPosts(): Response<Post> {
        return Instance.api.getCustomPosts()
    }

}