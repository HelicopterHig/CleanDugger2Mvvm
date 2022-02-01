package com.example.data.usecase

import com.example.data.models.CoinName

class GetCoinValueFromApiUseCase {

    fun execute(): CoinName {
        return CoinName(firstName = "BTC", title ="BitCoin" )

    }
}