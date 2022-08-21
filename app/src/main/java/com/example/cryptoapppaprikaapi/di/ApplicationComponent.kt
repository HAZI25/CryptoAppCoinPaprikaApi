package com.example.cryptoapppaprikaapi.di

import com.example.cryptoapppaprikaapi.presentation.coin_list.CoinListFragment
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(activity: CoinListFragment)
}