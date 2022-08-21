package com.example.cryptoapppaprikaapi.data.network

import com.example.cryptoapppaprikaapi.data.network.model.CoinDetailsDto
import com.example.cryptoapppaprikaapi.data.network.model.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinService {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetailsByCoinId(@Path("coinId") coinId: String): CoinDetailsDto
}