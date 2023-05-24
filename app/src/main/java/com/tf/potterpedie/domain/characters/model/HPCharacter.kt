package com.tf.potterpedie.domain.characters.model


data class HPCharacter(
    val id: String,
    val actor: String,
    val alive: Boolean,
    val alternateActors: List<String>,
    val alternateNames: List<String>,
    val ancestry: String,
    val dateOfBirth: String,
    val eyeColour: String,
    val gender: String,
    val hairColour: String,
    val hogwartsStaff: Boolean,
    val hogwartsStudent: Boolean,
    val house: String,
    val image: String,
    val name: String,
    val patronus: String,
    val species: String,
    val wand: Wand,
    val wizard: Boolean,
    val yearOfBirth: Int
)

data class Wand(
    val core: String,
    val length: Double,
    val wood: String
)
