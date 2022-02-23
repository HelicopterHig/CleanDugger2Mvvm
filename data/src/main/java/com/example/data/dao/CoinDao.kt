package com.example.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.Coin

@Dao
interface CoinDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCoin(coin: Coin)

    @Query("SELECT * FROM coin_table ")
    fun readAllData(): LiveData<List<Coin>>

}