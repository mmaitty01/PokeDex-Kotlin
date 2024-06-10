package org.swu.pokedex0528.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class SimplePokemon(

    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String

) : Parcelable {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    fun getSimplePokemonImage(): String {
        var serviceId = ""
        url.split("/").also {
            serviceId = it[it.size - 2]
        }
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$serviceId.png"
    }

}
