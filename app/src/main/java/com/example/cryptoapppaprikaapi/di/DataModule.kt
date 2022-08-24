package com.example.cryptoapppaprikaapi.di

import android.app.Application
import com.example.cryptoapppaprikaapi.common.Constants.BASE_URL
import com.example.cryptoapppaprikaapi.data.database.AppDatabase
import com.example.cryptoapppaprikaapi.data.database.CoinDao
import com.example.cryptoapppaprikaapi.data.network.CoinService
import com.example.cryptoapppaprikaapi.data.repository.CoinRepositoryImpl
import com.example.cryptoapppaprikaapi.domain.repository.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(repositoryImpl: CoinRepositoryImpl): CoinRepository

    companion object {
        @Provides
        @ApplicationScope
        fun provideCoinService(): CoinService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CoinService::class.java)
        }

        @Provides
        @ApplicationScope
        fun provideCoinDao(application: Application): CoinDao {
            return AppDatabase.getInstance(application).coinDao()
        }
    }
}