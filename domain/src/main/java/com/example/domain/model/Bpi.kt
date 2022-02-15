package com.example.data.api.model

import com.example.domain.model.EUR
import com.example.domain.model.GBP
import com.example.domain.model.USD
import com.google.gson.annotations.SerializedName


data class Bpi(
    //val wallet : Wallet
    @SerializedName("USD")
    val usd: USD,
    @SerializedName("GBP")
    val gbp: GBP,
    @SerializedName("EUR")
    val eur: EUR

)