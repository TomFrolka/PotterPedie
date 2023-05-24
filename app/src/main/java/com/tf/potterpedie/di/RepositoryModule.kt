package com.tf.potterpedie.di

import com.tf.potterpedie.data.characters.network.ICharactersNetworkDataSource
import com.tf.potterpedie.data.characters.network.mapper.HPCharactersMapper
import com.tf.potterpedie.data.characters.network.model.HPCharacterDto
import com.tf.potterpedie.data.characters.repository.CharactersRepository
import com.tf.potterpedie.domain.characters.ICharactersRepository
import com.tf.potterpedie.domain.characters.model.HPCharacter
import com.tf.potterpedie.domain.util.DomainMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCharactersRepository(
        networkDataSource: ICharactersNetworkDataSource,
        mapper: HPCharactersMapper
    ): ICharactersRepository {
        return CharactersRepository(
            networkDataSource,
            mapper
        )
    }

    @Singleton
    @Provides
    fun provideCharactersMapper(): DomainMapper<HPCharacterDto, HPCharacter> {
        return HPCharactersMapper()
    }


}