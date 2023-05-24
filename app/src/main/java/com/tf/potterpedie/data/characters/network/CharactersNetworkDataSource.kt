package com.tf.potterpedie.data.characters.network

import com.tf.potterpedie.data.characters.network.model.HPCharacterDto
import com.tf.potterpedie.data.core.BaseNetworkDataSource
import com.tf.potterpedie.domain.core.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharactersNetworkDataSource(
    private val networkService: ICharactersNetworkService
): BaseNetworkDataSource(), ICharactersNetworkDataSource {
    override suspend fun getAllCharacters(): DataState<List<HPCharacterDto>> =
        withContext(Dispatchers.IO){
            getResult {
                networkService.getAllCharacters()
            }
        }
}