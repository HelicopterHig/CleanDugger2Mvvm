package com.example.data.repository

import androidx.lifecycle.LiveData
import com.example.data.dao.CoinDao
import com.example.data.model.Coin


class CoinRepositoryInit(private val coinDao: CoinDao) {

    val readAllData: LiveData<List<Coin>> = coinDao.readAllData()

     suspend fun addCoin(coin: Coin){
        coinDao.addCoin(coin)
    }

}