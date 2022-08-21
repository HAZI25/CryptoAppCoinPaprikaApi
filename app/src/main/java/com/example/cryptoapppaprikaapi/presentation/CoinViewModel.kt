package com.example.cryptoapppaprikaapi.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapppaprikaapi.domain.model.Coin
import com.example.cryptoapppaprikaapi.domain.model.CoinDetails
import com.example.cryptoapppaprikaapi.domain.use_case.GetCoinDetailsByCoinId
import com.example.cryptoapppaprikaapi.domain.use_case.GetCoinsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val getCoinDetailsUseCase: GetCoinDetailsByCoinId,
) : ViewModel() {

    private val _coins = MutableLiveData<List<Coin>>()
    val coins: LiveData<List<Coin>> get() = _coins

    private val _coinDetails = MutableLiveData<CoinDetails>()
    val coinDetails: LiveData<CoinDetails> get() = _coinDetails

    fun loadCoins() {
        viewModelScope.launch {
            val coins = getCoinsUseCase()
            _coins.postValue(coins)
        }
    }

    fun loadCoinDetails(coinId: String) {
        viewModelScope.launch {
            val coinDetails = getCoinDetailsUseCase(coinId)
            _coinDetails.postValue(coinDetails)
        }
    }
}