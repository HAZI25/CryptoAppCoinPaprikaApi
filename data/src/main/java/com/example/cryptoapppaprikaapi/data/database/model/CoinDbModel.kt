package com.example.cryptoapppaprikaapi.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coin_list_table")
class CoinDbModel(
    @PrimaryKey
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val rank: Int,
    val name: String,
    val symbol: String,
)
