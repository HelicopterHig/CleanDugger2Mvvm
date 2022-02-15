package com.example.cleandugger2mvvm.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Post
import com.example.domain.repository.Repository
import com.example.domain.usecase.GetWalletInfoUseCase
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val getWalletInfoUseCase: GetWalletInfoUseCase): ViewModel() {


    val myResponse: MutableLiveData<Post> = MutableLiveData()
    //var myCustomPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    var myCustomPosts: MutableLiveData<Response<Post>> = MutableLiveData()





    fun getCustomPosts() {
        viewModelScope.launch {
            val response = getWalletInfoUseCase.getCustomPost()
            myCustomPosts.value = response
        }
    }

}








































