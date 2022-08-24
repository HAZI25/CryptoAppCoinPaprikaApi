package com.example.cryptoapppaprikaapi.presentation

import androidx.lifecycle.*
import com.example.cryptoapppaprikaapi.domain.model.CoinDetails
import com.example.cryptoapppaprikaapi.domain.use_case.GetCoinDetailsByCoinId
import com.example.cryptoapppaprikaapi.domain.use_case.GetCoinsUseCase
import com.example.cryptoapppaprikaapi.domain.use_case.LoadCoinsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val getCoinDetailsUseCase: GetCoinDetailsByCoinId,
    private val loadCoinsUseCase: LoadCoinsUseCase,
) : ViewModel() {

    val coins = getCoinsUseCase().asLiveData()

    private val _coinDetails = MutableLiveData<CoinDetails>()
    val coinDetails: LiveData<CoinDetails> get() = _coinDetails

    fun loadCoins() {
        viewModelScope.launch {
            loadCoinsUseCase()
        }
    }

    fun loadCoinDetails(coinId: String) {
        viewModelScope.launch {
            val coinDetails = getCoinDetailsUseCase(coinId)
            _coinDetails.postValue(coinDetails)
        }
    }
}