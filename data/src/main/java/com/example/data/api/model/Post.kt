package com.example.data.api.model

import com.google.gson.annotations.SerializedName

data class Post(

    val bpi: Bpi,
    val chartName: String,
    val disclaimer: String,
    val time: Time
)