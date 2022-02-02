package com.example.cleandugger2mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.api.model.Post
import com.example.data.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: com.example.data.repository.Repository): ViewModel() {


    val myResponse: MutableLiveData<com.example.data.api.model.Post> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response : com.example.data.api.model.Post = repository.getPost()
            myResponse.value = response
        }
    }

}








































