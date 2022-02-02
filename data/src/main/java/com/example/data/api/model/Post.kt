package com.example.data.api.model

data class Post(
    val time: Time,
    val disclaimer : String,
    val chartName : String,
    val bpi: Bpi
)