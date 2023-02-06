package com.example.data.extensions

import com.example.data.model.CoinModel
import com.example.domain.model.Coin

fun CoinModel.toCoin(): Coin {
    return Coin(
        id, isActive, name, rank, symbol
    )
}