package com.example.cryptoapppaprikaapi.data.network.model


import com.google.gson.annotations.SerializedName

class CoinDetailsDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("team")
    val team: List<TeamDto>,
)