package org.swu.pokedex0528.service.httpmanager

import okhttp3.OkHttpClient
import org.swu.pokedex0528.service.gateway.PokemonService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class PokemonHttpManager(){

    private val baseUrl = "https://pokeapi.co/"

    private val httpClient = OkHttpClient.Builder().apply {
        connectTimeout(60, TimeUnit.SECONDS)
        readTimeout(60, TimeUnit.SECONDS)
        writeTimeout(60, TimeUnit.SECONDS)
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .build()

    fun getPokemonService(): PokemonService {
        return retrofit.create(PokemonService::class.java)
    }
}
