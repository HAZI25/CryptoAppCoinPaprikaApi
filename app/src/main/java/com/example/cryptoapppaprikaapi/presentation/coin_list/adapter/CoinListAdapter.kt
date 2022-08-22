package com.example.cryptoapppaprikaapi.presentation.coin_list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapppaprikaapi.databinding.ItemCoinBinding

class CoinListAdapter : RecyclerView.Adapter<CoinListViewHolder>() {

    val differ = AsyncListDiffer(this, CoinDiffCallback())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinListViewHolder {
        val binding = ItemCoinBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CoinListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinListViewHolder, position: Int) {
        val binding = holder.binding
        val coin = differ.currentList[position]

        with(binding) {
            tvCoinRank.text = "${coin.rank}."
            tvName.text = "${coin.name} (${coin.symbol})"
            tvActive.text = if (coin.isActive) "Active" else "NotActive"
            if (coin.isNew) {
                tvIsNew.visibility = View.VISIBLE
                tvIsNew.text = "New!"
            } else {
                tvIsNew.visibility = View.GONE
            }
            root.setOnClickListener {
                onCoinClickListener?.let {
                    it(coin.id)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    var onCoinClickListener: ((String) -> Unit)? = null
}