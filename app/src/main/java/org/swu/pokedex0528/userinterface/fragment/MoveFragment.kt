package org.swu.pokedex0528.userinterface.fragment

import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.swu.pokedex0528.R
import org.swu.pokedex0528.base.service.DataBindingFragment
import org.swu.pokedex0528.databinding.FragmentMoveBinding
import org.swu.pokedex0528.userinterface.adapter.MoveListAdapter
import org.swu.pokedex0528.viewmodel.PokeDexViewModel

class MoveFragment: DataBindingFragment<FragmentMoveBinding>(){

    private val viewModel : PokeDexViewModel by sharedViewModel()
    private val adapter = MoveListAdapter(mutableListOf())

    companion object{
        const val TAG = "MoveFragment"
    }

    override fun layoutId(): Int = R.layout.fragment_move

    override fun start() {

        initView()

        initObserver()

    }

    private fun initView() {
        viewBinding.recyclerView.adapter = adapter
    }
    private fun initObserver() {

        viewModel.pokemonDetail.observe(this, Observer {

            with(viewBinding){

                viewBinding.tvAbilityValue.text = when(it.abilities.size){
                    2 ->{
                        "${it.abilities[0].getAbilityDetail()} , ${it.abilities[1].getAbilityDetail()}"
                    }
                    1 ->{
                        it.abilities[0].getAbilityDetail()
                    }
                    else -> ""

                }
                adapter.setData(it.moves)

            }

        })

    }

}
