package com.example.cryptoapppaprikaapi.data.repository

import com.example.cryptoapppaprikaapi.data.network.CoinMapper
import com.example.cryptoapppaprikaapi.data.network.CoinService
import com.example.cryptoapppaprikaapi.domain.model.Coin
import com.example.cryptoapppaprikaapi.domain.model.CoinDetails
import com.example.cryptoapppaprikaapi.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi: CoinService,
    private val mapper: CoinMapper,
) : CoinRepository {

    override suspend fun getCoins(): List<Coin> {
        return coinApi.getCoins().map {
            mapper.mapCoinDtoToEntity(it)
        }
    }

    override suspend fun getCoinDetailsByCoinId(coinId: String): CoinDetails {
        return mapper.mapCoinDetailsDtoToEntity(coinApi.getCoinDetailsByCoinId(coinId))
    }
}