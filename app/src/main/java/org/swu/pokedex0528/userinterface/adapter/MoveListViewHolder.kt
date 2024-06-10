package org.swu.pokedex0528.userinterface.adapter

import androidx.recyclerview.widget.RecyclerView
import org.swu.pokedex0528.databinding.ItemMoveListBinding
import org.swu.pokedex0528.model.Move

class MoveListViewHolder(private val binding: ItemMoveListBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(data: Move) {
        binding.apply {
            this.data = data
            executePendingBindings()
        }
    }
}
