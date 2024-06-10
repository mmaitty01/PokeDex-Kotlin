package org.swu.pokedex0528.model

import com.google.gson.annotations.SerializedName

data class Sprites(
    @SerializedName("back_default")
    val backDefault: String? = null,

    @SerializedName("back_female")
    val backFemale: String? = null,

    @SerializedName("back_shiny")
    val backShiny: String? = null,

    @SerializedName("back_shiny_female")
    val backShinyFemale: String? = null,

    @SerializedName("front_default")
    val frontDefault: String? = null,

    @SerializedName("front_female")
    val frontFemale: String? = null,

    @SerializedName("front_shiny")
    val frontShiny: String? = null,

    @SerializedName("front_shiny_female")
    val frontShinyFemale: String? = null,

    val other: Other? = null,
)
data class HomeSprite(
    @SerializedName( "front_default")
    val frontDefault:  String? = null,

    @SerializedName( "front_female")
    val frontFemale:  String? = null,

    @SerializedName( "front_shiny")
    val frontShiny:  String? = null,

    @SerializedName( "front_shiny_female")
    val frontShinyFemale:  String? = null,
)

data class DreamWorld(
    @SerializedName( "front_default")
    val frontDefault: String? = null,

    @SerializedName( "front_female")
    val frontFemale:  String? = null,
)

data class Other(
    @SerializedName( "dream_world")
    val dreamWorld: DreamWorld,

    @SerializedName( "home")
    val home: HomeSprite,

    @SerializedName( "official-artwork")
    val officialArtwork: OfficialArtwork
)

data class OfficialArtwork(
    @SerializedName( "front_default")
    val frontDefault: String
)
