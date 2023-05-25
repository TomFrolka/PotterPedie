package com.tf.potterpedie.domain.characters.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HPCharacter(
    val id: String,
    val actor: String,
    val alive: Boolean,
    val alternateActors: List<String>,
    val alternateNames: List<String>,
    val ancestry: String,
    val dateOfBirth: String,
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
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
): Parcelable
@Parcelize
data class Wand(
    val core: String,
    val length: Double,
    val wood: String
): Parcelable
