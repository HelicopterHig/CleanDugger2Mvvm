package com.example.cleandugger2mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleandugger2mvvm.model.Post
import com.example.cleandugger2mvvm.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {


    val myResponse: MutableLiveData<Post> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response : Post = repository.getPost()
            myResponse.value = response
        }
    }

}








































