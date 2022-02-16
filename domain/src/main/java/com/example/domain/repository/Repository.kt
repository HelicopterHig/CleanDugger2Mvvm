package com.example.domain.repository

import com.example.domain.model.Post
import retrofit2.Response

interface Repository {
    suspend fun getCustomPosts(): Response<Post>
}