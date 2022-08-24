package com.example.cryptoapppaprikaapi.data.repository

import com.example.cryptoapppaprikaapi.data.database.CoinDao
import com.example.cryptoapppaprikaapi.data.mapper.CoinMapper
import com.example.cryptoapppaprikaapi.data.network.CoinService
import com.example.cryptoapppaprikaapi.domain.model.Coin
import com.example.cryptoapppaprikaapi.domain.model.CoinDetails
import com.example.cryptoapppaprikaapi.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi: CoinService,
    private val mapper: CoinMapper,
    private val dao: CoinDao,
) : CoinRepository {

    override fun getCoins(): Flow<List<Coin>> {
        return dao.getCoins().map {
            it.map { coinDbModel ->
                mapper.mapDbModelToEntity(coinDbModel)
            }
        }
    }

    override suspend fun getCoinDetailsByCoinId(coinId: String): CoinDetails {
        return mapper.mapCoinDetailsDtoToEntity(coinApi.getCoinDetailsByCoinId(coinId))
    }

    override suspend fun loadCoins() {
        val coinsDbModel = coinApi.getCoins().map { mapper.mapDtoToDbModel(it) }
        dao.insertCoinList(coinsDbModel)
    }
}