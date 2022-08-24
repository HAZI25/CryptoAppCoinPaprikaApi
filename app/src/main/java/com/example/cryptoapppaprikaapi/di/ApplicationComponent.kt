package com.example.cryptoapppaprikaapi.di

import android.app.Application
import com.example.cryptoapppaprikaapi.presentation.coin_details.CoinDetailsFragment
import com.example.cryptoapppaprikaapi.presentation.coin_list.CoinListFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(fragment: CoinListFragment)
    fun inject(fragment: CoinDetailsFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}