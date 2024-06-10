package org.swu.pokedex0528.service.gateway

import org.swu.pokedex0528.model.PokemonDetail
import org.swu.pokedex0528.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("api/v2/pokemon/")
    suspend fun getPokemonList(@Query("limit") limit : Int) : PokemonListResponse

    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name : String) : PokemonDetail

}
