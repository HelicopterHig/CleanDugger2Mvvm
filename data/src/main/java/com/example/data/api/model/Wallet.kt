package com.example.data.api.model

import com.google.gson.annotations.SerializedName

data class Wallet(
   @SerializedName("USD")
   val usd: USD
)