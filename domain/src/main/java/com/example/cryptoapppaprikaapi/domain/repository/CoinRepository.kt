package com.example.cryptoapppaprikaapi.domain.repository

import com.example.cryptoapppaprikaapi.domain.model.Coin
import com.example.cryptoapppaprikaapi.domain.model.CoinDetails
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    fun getCoins(): Flow<List<Coin>>

    suspend fun getCoinDetailsByCoinId(coinId: String): CoinDetails

    suspend fun loadCoins()
}