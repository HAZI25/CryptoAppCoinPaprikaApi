package com.example.cryptoapppaprikaapi.data.network

import com.example.cryptoapppaprikaapi.data.network.model.CoinDetailsDto
import com.example.cryptoapppaprikaapi.data.network.model.CoinDto
import com.example.cryptoapppaprikaapi.data.network.model.TeamDto
import com.example.cryptoapppaprikaapi.domain.model.Coin
import com.example.cryptoapppaprikaapi.domain.model.CoinDetails
import com.example.cryptoapppaprikaapi.domain.model.Team
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

    private fun mapTeamDtoToEntity(dto: TeamDto): Team {
        return with(dto) {
            Team(id, name, position)
        }
    }
}