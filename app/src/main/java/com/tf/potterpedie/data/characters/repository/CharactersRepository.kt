package com.tf.potterpedie.data.characters.repository

import com.tf.potterpedie.data.characters.network.ICharactersNetworkDataSource
import com.tf.potterpedie.data.characters.network.model.HPCharacterDto
import com.tf.potterpedie.domain.characters.ICharactersRepository
import com.tf.potterpedie.domain.characters.model.HPCharacter
import com.tf.potterpedie.domain.core.DataState
import com.tf.potterpedie.domain.util.DomainMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharactersRepository(
    private val networkDataSource: ICharactersNetworkDataSource,
    private val mapper: DomainMapper<HPCharacterDto, HPCharacter>
) : ICharactersRepository {
    override suspend fun getAllCharacters(): Flow<DataState<List<HPCharacter>>> = flow {
        emit(DataState.Loading())
        when (val networkCallResult = networkDataSource.getAllCharacters()) {
            is DataState.Error -> {
                emit(DataState.Error(networkCallResult.message))
            }

            is DataState.Success -> {
                val events = networkCallResult.data.map { dto ->
                    mapper.mapToDomainModel(dto)
                }
                emit(DataState.Success(events))
            }

            else -> {
                emit(DataState.Success(emptyList()))
            }
        }
    }
}