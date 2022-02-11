package com.example.cleandugger2mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.api.model.Post
import com.example.data.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {


    val myResponse: MutableLiveData<Post> = MutableLiveData()
    //var myCustomPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    var myCustomPosts: MutableLiveData<Response<Post>> = MutableLiveData()





    fun getCustomPosts() {
        viewModelScope.launch {
            val response = repository.getCustomPosts()
            myCustomPosts.value = response
        }
    }

}








































