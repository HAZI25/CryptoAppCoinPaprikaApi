package com.example.cryptoapppaprikaapi.domain.use_case

import com.example.cryptoapppaprikaapi.domain.repository.CoinRepository
import javax.inject.Inject

class LoadCoinsUseCase @Inject constructor(
    private val repository: CoinRepository,
) {
    suspend operator fun invoke() {
        return repository.loadCoins()
    }
}