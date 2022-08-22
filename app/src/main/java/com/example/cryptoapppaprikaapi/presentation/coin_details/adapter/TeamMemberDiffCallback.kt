package com.example.cryptoapppaprikaapi.presentation.coin_details.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapppaprikaapi.domain.model.TeamMember

class TeamMemberDiffCallback : DiffUtil.ItemCallback<TeamMember>() {
    override fun areItemsTheSame(oldItem: TeamMember, newItem: TeamMember): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TeamMember, newItem: TeamMember): Boolean {
        return oldItem == newItem
    }
}