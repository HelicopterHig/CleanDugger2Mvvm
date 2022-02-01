package com.example.cleandugger2mvvm.repository

import com.example.cleandugger2mvvm.api.Instance
import com.example.cleandugger2mvvm.model.Post

class Repository {

    suspend fun getPost() : Post {
        return  Instance.api.getPost()
    }
}