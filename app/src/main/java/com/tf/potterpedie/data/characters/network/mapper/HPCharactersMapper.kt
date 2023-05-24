package com.tf.potterpedie.data.characters.network.mapper

import com.tf.potterpedie.data.characters.network.model.HPCharacterDto
import com.tf.potterpedie.data.characters.network.model.WandDto
import com.tf.potterpedie.domain.characters.model.HPCharacter
import com.tf.potterpedie.domain.characters.model.Wand
import com.tf.potterpedie.domain.util.DomainMapper

class HPCharactersMapper: DomainMapper<HPCharacterDto, HPCharacter> {
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
            eyeColour = model.eyeColour,
            gender = model.gender,
            hairColour = model.hairColour,
            hogwartsStaff = model.hogwartsStaff,
            hogwartsStudent = model.hogwartsStudent,
            house = model.house,
            image = model.house,
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
            eyeColour = domainModel.eyeColour,
            gender = domainModel.gender,
            hairColour = domainModel.hairColour,
            hogwartsStaff = domainModel.hogwartsStaff,
            hogwartsStudent = domainModel.hogwartsStudent,
            house = domainModel.house,
            image = domainModel.house,
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