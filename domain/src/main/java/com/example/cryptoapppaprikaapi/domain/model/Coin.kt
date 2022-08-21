package com.example.cryptoapppaprikaapi.domain.model

data class Coin(
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val rank: Int,
    val name: String,
    val symbol: String
)