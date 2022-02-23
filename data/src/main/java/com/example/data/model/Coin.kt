package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coin_table")

data class Coin(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val chartName: String,
    val usdRate: String,
    val gbpRate: String,
    val eurRate: String
)