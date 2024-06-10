package org.swu.pokedex0528.userinterface.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class PokemonDetailPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm,lifecycle) {

    private val fragmentList : MutableList<Fragment> = mutableListOf()

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]

    fun setFragment(fragmentList : List<Fragment>){
        this.fragmentList.addAll(fragmentList)
        notifyDataSetChanged()
    }

}
