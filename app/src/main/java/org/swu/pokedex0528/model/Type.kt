package org.swu.pokedex0528.model

import com.google.gson.annotations.SerializedName

// Type.kt

data class Type(
    @SerializedName("slot") val slot: Int,
    @SerializedName("type")  val typeName: BaseName
)