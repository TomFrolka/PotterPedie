package com.tf.potterpedie.data.characters.network.model

import com.google.gson.annotations.SerializedName


data class HPCharacterDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("actor")
    val actor: String,
    @SerializedName("alive")
    val alive: Boolean,
    @SerializedName("alternate_actors")
    val alternateActors: List<String>,
    @SerializedName("alternate_names")
    val alternateNames: List<String>,
    @SerializedName("ancestry")
    val ancestry: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String? = null,
    @SerializedName("eyeColour")
    val eyeColour: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("hairColour")
    val hairColour: String,
    @SerializedName("hogwartsStaff")
    val hogwartsStaff: Boolean,
    @SerializedName("hogwartsStudent")
    val hogwartsStudent: Boolean,
    @SerializedName("house")
    val house: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("patronus")
    val patronus: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("wand")
    val wandDto: WandDto,
    @SerializedName("wizard")
    val wizard: Boolean,
    @SerializedName("yearOfBirth")
    val yearOfBirth: Int? = null
)

data class WandDto(
    @SerializedName("core")
    val core: String,
    @SerializedName("length")
    val length: Double? = null,
    @SerializedName("wood")
    val wood: String
)

