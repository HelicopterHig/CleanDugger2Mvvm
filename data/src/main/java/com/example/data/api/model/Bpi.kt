package com.example.data.api.model

import com.google.gson.annotations.SerializedName


data class Bpi(
    @SerializedName("USD")
    val usd: USD,
    @SerializedName("GBP")
    val gbp: GBP,
    @SerializedName("EUR")
    val eur: EUR
)