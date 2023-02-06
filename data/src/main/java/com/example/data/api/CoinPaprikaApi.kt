package com.example.data.api

import com.example.data.model.CoinModel
import com.example.domain.model.Coin
import retrofit2.http.GET

interface CoinPaprikaApi {

    @GET("v1/coins")
    suspend fun getCoins(): List<CoinModel>

}