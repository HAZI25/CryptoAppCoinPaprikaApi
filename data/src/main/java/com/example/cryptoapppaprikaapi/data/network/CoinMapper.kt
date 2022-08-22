package com.example.cryptoapppaprikaapi.data.network

import com.example.cryptoapppaprikaapi.data.network.model.CoinDetailsDto
import com.example.cryptoapppaprikaapi.data.network.model.CoinDto
import com.example.cryptoapppaprikaapi.data.network.model.TeamMemberDto
import com.example.cryptoapppaprikaapi.domain.model.Coin
import com.example.cryptoapppaprikaapi.domain.model.CoinDetails
import com.example.cryptoapppaprikaapi.domain.model.TeamMember
import javax.inject.Inject

class CoinMapper @Inject constructor() {

    fun mapCoinDtoToEntity(dto: CoinDto): Coin {
        return with(dto) {
            Coin(id, isActive, isNew, rank, name, symbol)
        }
    }

    fun mapCoinDetailsDtoToEntity(dto: CoinDetailsDto): CoinDetails {
        return with(dto) {
            CoinDetails(description,
                id,
                isActive,
                rank,
                isNew,
                name,
                symbol,
                team.map { mapTeamDtoToEntity(it) })
        }
    }

    private fun mapTeamDtoToEntity(dto: TeamMemberDto): TeamMember {
        return with(dto) {
            TeamMember(id, name, position)
        }
    }
}