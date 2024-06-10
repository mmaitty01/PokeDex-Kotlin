package org.swu.pokedex0528.model

import com.google.gson.annotations.SerializedName

data class BaseName(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url : String
)




