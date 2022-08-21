package com.example.cryptoapppaprikaapi.presentation.coin_list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapppaprikaapi.domain.model.Coin

class CoinDiffCallback : DiffUtil.ItemCallback<Coin>() {
    override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
        return oldItem == newItem
    }
}