package com.example.data.usecase

import com.example.data.models.SaveCoinParam

class SaveCoinNameUseCase {

    fun execute (param : SaveCoinParam) : Boolean {
        if (param.name.isEmpty()){
            return false
        } else {
            return true
        }

    }
}