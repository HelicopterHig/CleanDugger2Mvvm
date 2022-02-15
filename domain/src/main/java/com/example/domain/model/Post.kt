package com.example.domain.model

import com.example.data.api.model.Bpi

data class Post(
    val bpi: Bpi,
    val chartName: String,
    val disclaimer: String,
    val time: Time
)