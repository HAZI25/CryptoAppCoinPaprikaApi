package com.example.cryptoapppaprikaapi.domain.model

data class CoinDetails(
    val description: String,
    val id: String,
    val isActive: Boolean,
    val rank: Int,
    val isNew: Boolean,
    val name: String,
    val symbol: String,
    val team: List<TeamMember>
)
