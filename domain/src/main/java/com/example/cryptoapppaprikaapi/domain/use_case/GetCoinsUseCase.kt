package com.example.cryptoapppaprikaapi.domain.use_case

import com.example.cryptoapppaprikaapi.domain.model.Coin
import com.example.cryptoapppaprikaapi.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository,
) {
    suspend operator fun invoke(): List<Coin> {
        return repository.getCoins()
    }
}