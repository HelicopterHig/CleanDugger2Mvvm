package com.example.data.repository

import com.example.data.api.Instance
import com.example.data.api.model.Post

class Repository {

    suspend fun getPost() : com.example.data.api.model.Post {
        return  com.example.data.api.Instance.api.getPost()
    }
}