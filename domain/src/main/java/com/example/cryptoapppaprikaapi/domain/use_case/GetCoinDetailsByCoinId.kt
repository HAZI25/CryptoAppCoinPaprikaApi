package com.example.cryptoapppaprikaapi.domain.use_case

import com.example.cryptoapppaprikaapi.domain.model.CoinDetails
import com.example.cryptoapppaprikaapi.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinDetailsByCoinId @Inject constructor(
    private val repository: CoinRepository,
) {
    suspend operator fun invoke(coinId: String): CoinDetails {
        return repository.getCoinDetailsByCoinId(coinId)
    }
}