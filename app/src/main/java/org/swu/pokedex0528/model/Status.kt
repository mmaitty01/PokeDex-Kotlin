package org.swu.pokedex0528.model

import com.google.gson.annotations.SerializedName

// Status.kt

data class Status(
    @SerializedName("base_stat") val baseStat:Int,
    @SerializedName("stat") val statName: BaseName
)