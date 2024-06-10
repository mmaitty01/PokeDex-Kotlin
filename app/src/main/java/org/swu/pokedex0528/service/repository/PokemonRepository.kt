package org.swu.pokedex0528.service.repository

import android.util.Log
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.swu.pokedex0528.base.service.UseCaseResult
import org.swu.pokedex0528.database.dao.PokemonDatabase
import org.swu.pokedex0528.extension.handleUseCaseException
import org.swu.pokedex0528.model.PokemonDetail
import org.swu.pokedex0528.model.PokemonListResponse
import org.swu.pokedex0528.service.gateway.PokemonService

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int): UseCaseResult<PokemonListResponse>
    suspend fun getPokemonDetail(name: String): UseCaseResult<PokemonDetail>
}

class PokemonRepositoryImpl(private val pokemonService: PokemonService) : PokemonRepository,
    KoinComponent {

    private val simplePokemonDatabase: PokemonDatabase by inject()

    override suspend fun getPokemonList(limit: Int): UseCaseResult<PokemonListResponse> {

        with(simplePokemonDatabase.simplePokemonDao()) {
            val dataList = getAllSimplePokemon(limit)
            return handleUseCaseException() {
                if (dataList.isNotEmpty()) {
                    Log.d("getPokemonList","isDataExist = ${dataList.isNotEmpty()} : Loading data from local database...")
                    PokemonListResponse(count = 0, pokemonList = dataList)
                } else {
                    Log.d("getPokemonList","isDataExist = ${dataList.isNotEmpty()} : Loading data from service from Sever...")
                    val res = pokemonService.getPokemonList(limit)
                    try {
                        Log.d("getPokemonList","Saving simple pokemon data to local database...")
                        insertAllData(res.pokemonList)
                    }catch (e:Exception){
                        Log.d("getPokemonList","Saving error with ...${e.message}")
                    }
                    res
                }
            }
        }

    }
    override suspend fun getPokemonDetail(name: String): UseCaseResult<PokemonDetail> {
        return handleUseCaseException {
            pokemonService.getPokemonDetail(name)
        }
    }


}
