package com.tf.potterpedie.data.characters.network.mapper

import com.tf.potterpedie.data.characters.network.model.HPCharacterDto
import com.tf.potterpedie.data.characters.network.model.WandDto
import com.tf.potterpedie.domain.characters.model.HPCharacter
import com.tf.potterpedie.domain.characters.model.Wand
import com.tf.potterpedie.domain.util.DomainMapper
import javax.inject.Inject

class HPCharactersMapper @Inject constructor() : DomainMapper<HPCharacterDto, HPCharacter> {
    override fun mapToDomainModel(model: HPCharacterDto): HPCharacter =
        HPCharacter(
            id = model.id,
            actor = model.actor,
            name = model.name,
            alive = model.alive,
            alternateActors = model.alternateActors,
            alternateNames = model.alternateNames,
            ancestry = model.ancestry,
            dateOfBirth = model.dateOfBirth ?: "",
            eyeColor = model.eyeColor,
            gender = model.gender,
            hairColor = model.hairColor,
            hogwartsStaff = model.hogwartsStaff,
            hogwartsStudent = model.hogwartsStudent,
            house = model.house,
            image = model.image,
            patronus = model.patronus,
            species = model.species,
            wand = Wand(
                core = model.wandDto.core,
                length = model.wandDto.length ?: 0.0,
                wood = model.wandDto.wood
            ),
            wizard = model.wizard,
            yearOfBirth = model.yearOfBirth ?: 0
        )

    override fun mapFromDomainModel(domainModel: HPCharacter): HPCharacterDto =
        HPCharacterDto(
            id = domainModel.id,
            actor = domainModel.actor,
            name = domainModel.name,
            alive = domainModel.alive,
            alternateActors = domainModel.alternateActors,
            alternateNames = domainModel.alternateNames,
            ancestry = domainModel.ancestry,
            dateOfBirth = domainModel.dateOfBirth,
            eyeColor = domainModel.eyeColor,
            gender = domainModel.gender,
            hairColor = domainModel.hairColor,
            hogwartsStaff = domainModel.hogwartsStaff,
            hogwartsStudent = domainModel.hogwartsStudent,
            house = domainModel.house,
            image = domainModel.image,
            patronus = domainModel.patronus,
            species = domainModel.species,
            wandDto = WandDto(
                core = domainModel.wand.core,
                length = domainModel.wand.length,
                wood = domainModel.wand.wood
            ),
            wizard = domainModel.wizard,
            yearOfBirth = domainModel.yearOfBirth
        )
}