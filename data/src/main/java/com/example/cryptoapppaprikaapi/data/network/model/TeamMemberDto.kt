package com.example.cryptoapppaprikaapi.data.network.model


import com.google.gson.annotations.SerializedName

class TeamMemberDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String
)