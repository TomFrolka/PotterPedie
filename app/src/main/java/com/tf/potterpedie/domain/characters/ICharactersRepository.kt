package com.tf.potterpedie.domain.characters

import com.tf.potterpedie.domain.characters.model.HPCharacter
import com.tf.potterpedie.domain.core.DataState
import kotlinx.coroutines.flow.Flow

interface ICharactersRepository {
    suspend fun getAllCharacters(): Flow<DataState<List<HPCharacter>>>
}