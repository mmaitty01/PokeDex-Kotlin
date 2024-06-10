package org.swu.pokedex0528.userinterface.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.swu.pokedex0528.databinding.ItemMoveListBinding
import org.swu.pokedex0528.model.Move

class MoveListAdapter(private val list : MutableList<Move>): RecyclerView.Adapter<MoveListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMoveListBinding.inflate(inflater, parent, false)
        return MoveListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoveListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setData(list:List<Move>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }


}
