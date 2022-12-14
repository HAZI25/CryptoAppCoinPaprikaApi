package com.example.cryptoapppaprikaapi.data.mapper

import com.example.cryptoapppaprikaapi.data.database.model.CoinDbModel
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

    fun mapDbModelToEntity(dbModel: CoinDbModel): Coin {
        return with(dbModel) {
            Coin(
                id, isActive, isNew, rank, name, symbol
            )
        }
    }

    fun mapDtoToDbModel(dto: CoinDto): CoinDbModel {
        return with(dto) {
            CoinDbModel(
                id, isActive, isNew, rank, name, symbol
            )
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