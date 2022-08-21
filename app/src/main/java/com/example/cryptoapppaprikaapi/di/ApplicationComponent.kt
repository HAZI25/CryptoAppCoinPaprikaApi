package com.example.cryptoapppaprikaapi.di

import com.example.cryptoapppaprikaapi.presentation.MainActivity
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
}