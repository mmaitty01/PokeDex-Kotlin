package org.swu.pokedex0528.model

import com.google.gson.annotations.SerializedName

data class Ability(
    @SerializedName("ability") val ability: BaseName,
    @SerializedName("is_hidden") val isHidden: Boolean,
    @SerializedName("slot") val slot: Int
){
    fun getAbilityDetail():String{
        val textHidden = if (isHidden) "(Hidden)" else ""
        return "${ability.name} $textHidden"
    }
}
