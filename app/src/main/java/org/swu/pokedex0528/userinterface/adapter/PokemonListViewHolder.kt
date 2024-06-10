package org.swu.pokedex0528.userinterface.adapter

import androidx.recyclerview.widget.RecyclerView
import org.swu.pokedex0528.databinding.ItemPokemonListBinding
import org.swu.pokedex0528.model.SimplePokemon

class PokemonListViewHolder(private val binding: ItemPokemonListBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(pokemonData: SimplePokemon) {
        binding.apply {
            data = pokemonData
            executePendingBindings()
        }
    }
}
