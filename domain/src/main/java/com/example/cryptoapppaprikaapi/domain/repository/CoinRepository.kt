package com.example.cryptoapppaprikaapi.domain.repository

import com.example.cryptoapppaprikaapi.domain.model.Coin
import com.example.cryptoapppaprikaapi.domain.model.CoinDetails

interface CoinRepository {

    suspend fun getCoins(): List<Coin>

    suspend fun getCoinDetailsByCoinId(coinId: String): CoinDetails
}