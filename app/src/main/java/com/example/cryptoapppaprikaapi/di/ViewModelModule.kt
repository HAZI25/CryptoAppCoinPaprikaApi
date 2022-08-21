package com.example.cryptoapppaprikaapi.di

import androidx.lifecycle.ViewModel
import com.example.cryptoapppaprikaapi.presentation.CoinViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @ViewModelKey(CoinViewModel::class)
    @IntoMap
    fun bindCoinViewModel(viewModel: CoinViewModel): ViewModel

}