package org.swu.pokedex0528.model

import com.google.gson.annotations.SerializedName

data class PokemonDetail(

    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("weight")
    val weight: Int,
    @SerializedName("base_experience")
    val baseExp: Int,
    @SerializedName("types")
    val types: List<Type>,
    @SerializedName("stats")
    val status: List<Status>,
    @SerializedName("abilities")
    val abilities: List<Ability>,
    @SerializedName("forms")
    val forms: List<BaseName>,
    @SerializedName("is_default")
    val isDefault: Boolean,
    @SerializedName("location_area_encounters")
    val locationAreaEncountersUrl: String,
    @SerializedName("moves")
    val moves: List<Move>,
    @SerializedName("species")
    val species: BaseName,
    @SerializedName("sprites")
    val sprites: Sprites

) {

    fun getDefaultPokemonImage(): String {
        return sprites.other?.officialArtwork?.frontDefault ?:
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
    }

}

