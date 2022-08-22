package com.example.cryptoapppaprikaapi.presentation.coin_details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapppaprikaapi.databinding.ItemTeamMemberBinding

class TeamMembersAdapter : RecyclerView.Adapter<TeamMemberViewHolder>() {

    val differ = AsyncListDiffer(this, TeamMemberDiffCallback())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamMemberViewHolder {
        val binding = ItemTeamMemberBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TeamMemberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamMemberViewHolder, position: Int) {
        val binding = holder.binding
        val teamMember = differ.currentList[position]
        with(binding) {
            tvName.text = teamMember.name
            tvPosition.text = teamMember.position
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}