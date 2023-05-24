package com.tf.potterpedie.data.characters.network

import com.tf.potterpedie.data.characters.network.model.HPCharacterDto
import com.tf.potterpedie.domain.core.DataState

interface ICharactersNetworkDataSource {
    suspend fun getAllCharacters(): DataState<List<HPCharacterDto>>
}