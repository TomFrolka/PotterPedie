package com.tf.potterpedie.data.characters.network

import com.tf.potterpedie.data.characters.network.model.HPCharacterDto
import retrofit2.Response
import retrofit2.http.GET

interface ICharactersNetworkService {
    @GET("characters")
    suspend fun getAllCharacters(): Response<List<HPCharacterDto>>
}