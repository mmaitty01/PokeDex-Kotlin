package org.swu.pokedex0528.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.swu.pokedex0528.base.service.UseCaseResult
import org.swu.pokedex0528.model.PokemonDetail
import org.swu.pokedex0528.model.SimplePokemon
import org.swu.pokedex0528.service.repository.PokemonRepository

class PokeDexViewModel(private val pokemonRepository: PokemonRepository): ViewModel(){

    private val _pokemonDetail = MutableLiveData<PokemonDetail>()
    val pokemonDetail : LiveData<PokemonDetail> = _pokemonDetail

    private val _pokemonList = MutableLiveData<List<SimplePokemon>>()
    val pokemonList : LiveData<List<SimplePokemon>> = _pokemonList

    private val _errorData = MutableLiveData<String>()
    val errorData : LiveData<String> = _errorData

    private val limit = 9999

    fun getPokemonList(){

        viewModelScope.launch {

            val res = withContext(Dispatchers.IO){
                pokemonRepository.getPokemonList(limit)
            }

            when(res){
                is UseCaseResult.Success ->{
                    _pokemonList.value = res.result.pokemonList
                }
                is UseCaseResult.Error ->{
                    _errorData.value = res.throwable.message
                }
            }

        }

    }
    fun getPokemonDetail(name:String){

        viewModelScope.launch {

            val res = withContext(Dispatchers.IO){
                pokemonRepository.getPokemonDetail(name)
            }

            when(res){
                is UseCaseResult.Success ->{
                    _pokemonDetail.value = res.result
                }
                is UseCaseResult.Error ->{
                    _errorData.value = res.throwable.message
                }
            }
        }
    }



}

