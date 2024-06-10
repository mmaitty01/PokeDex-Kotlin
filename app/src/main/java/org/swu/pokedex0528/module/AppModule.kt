package org.swu.pokedex0528.module

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.swu.pokedex0528.database.dao.PokemonDatabase
import org.swu.pokedex0528.service.httpmanager.PokemonHttpManager
import org.swu.pokedex0528.service.repository.PokemonRepository
import org.swu.pokedex0528.service.repository.PokemonRepositoryImpl
import org.koin.core.module.Module


val appModule = module {
   // factory { PokeDexViewModel(get()) }
    factory<PokemonRepository> { PokemonRepositoryImpl(get()) }
    factory { PokemonHttpManager().getPokemonService() }
    factory { PokemonDatabase(androidContext()) }
}
