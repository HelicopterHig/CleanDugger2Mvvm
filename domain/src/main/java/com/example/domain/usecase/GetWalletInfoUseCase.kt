package com.example.domain.usecase


import com.example.domain.model.Post
import com.example.domain.repository.Repository
import retrofit2.Response

class GetWalletInfoUseCase(val repository: Repository) {

    suspend fun getCustomPost(): Response<Post> {
        return repository.getCustomPosts()
    }
}