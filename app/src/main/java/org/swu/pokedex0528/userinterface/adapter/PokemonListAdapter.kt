package org.swu.pokedex0528.userinterface.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import org.swu.pokedex0528.databinding.ItemPokemonListBinding
import org.swu.pokedex0528.model.SimplePokemon
import java.util.*

class PokemonListAdapter(private val pokemonList : MutableList<SimplePokemon>): RecyclerView.Adapter<PokemonListViewHolder>() , Filterable {

    var pokemonFilterList : MutableList<SimplePokemon> = mutableListOf()

    init {
        pokemonFilterList = pokemonList
    }

    private var onClickListener : ((SimplePokemon)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPokemonListBinding.inflate(inflater, parent, false)
        return PokemonListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.bind(pokemonFilterList[position])
        holder.itemView.setOnClickListener {
            onClickListener?.invoke(pokemonFilterList[position])
        }
    }

    override fun getItemCount(): Int = pokemonFilterList.size

    fun setPokemonData(list:List<SimplePokemon>){
        this.pokemonList.clear()
        this.pokemonList.addAll(list)
        notifyDataSetChanged()
    }
    fun setOnClickListener(listener:(SimplePokemon)->Unit){
        this.onClickListener = listener
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    pokemonFilterList = pokemonList
                } else {
                    val resultList = mutableListOf<SimplePokemon>()
                    for (pokemon in pokemonList) {
                        if (pokemon.name.lowercase(Locale.ROOT).contains(charSearch.lowercase(Locale.ROOT))) {
                            resultList.add(pokemon)
                        }
                    }
                    pokemonFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = pokemonFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                pokemonFilterList = results?.values as MutableList<SimplePokemon>
                notifyDataSetChanged()
            }
        }
    }

}

