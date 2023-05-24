package com.tf.potterpedie.domain.characters

import com.tf.potterpedie.domain.characters.model.HPCharacter
import com.tf.potterpedie.domain.core.DataState

interface ICharactersRepository {
    suspend fun getAllCharacters(): DataState<List<HPCharacter>>
}