package com.example.cryptoapppaprikaapi

import android.app.Application
import com.example.cryptoapppaprikaapi.di.ApplicationComponent
import com.example.cryptoapppaprikaapi.di.DaggerApplicationComponent

class CryptocurrencyApp : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}