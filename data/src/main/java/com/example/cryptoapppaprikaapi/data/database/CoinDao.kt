package com.example.cryptoapppaprikaapi.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapppaprikaapi.data.database.model.CoinDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin_list_table")
    fun getCoins(): Flow<List<CoinDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoinList(coinsList: List<CoinDbModel>)

}