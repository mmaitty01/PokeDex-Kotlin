package org.swu.pokedex0528.userinterface.fragment

import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.swu.pokedex0528.R
import org.swu.pokedex0528.base.service.DataBindingFragment
import org.swu.pokedex0528.databinding.FragmentDetailBinding
import org.swu.pokedex0528.viewmodel.PokeDexViewModel

class DetailFragment: DataBindingFragment<FragmentDetailBinding>(){

    private val viewModel : PokeDexViewModel by sharedViewModel()


    companion object{
        const val TAG = "DetailFragment"
    }

    override fun layoutId(): Int = R.layout.fragment_detail

    override fun start() {


        initObserver()

    }

    private fun initObserver() {

        viewModel.pokemonDetail.observe(this, Observer {

            with(viewBinding){

                data = it
                executePendingBindings()


                tvTypeValue.text = if (it.types.size > 1){

                    "${it.types[0].typeName.name} , ${it.types[1].typeName.name}"

                }else{

                    it.types[0].typeName.name

                }
                for (stat in it.status){
                    when(stat.statName.name){
                        "hp" -> {
                            progressStatusHp.progress = stat.baseStat
                            tvStatusHpValue.text = stat.baseStat.toString()
                        }
                        "attack" -> {
                            progressStatusAtk.progress = stat.baseStat
                            tvStatusAtkValue.text = stat.baseStat.toString()
                        }
                        "defense" -> {
                            progressStatusDef.progress = stat.baseStat
                            tvStatusDefValue.text = stat.baseStat.toString()
                        }
                        "special-attack" -> {
                            progressStatusSa.progress = stat.baseStat
                            tvStatusSaValue.text = stat.baseStat.toString()
                        }
                        "special-defense" -> {
                            progressStatusSd.progress = stat.baseStat
                            tvStatusSdValue.text = stat.baseStat.toString()
                        }
                        "speed" -> {
                            progressStatusSp.progress = stat.baseStat
                            tvStatusSpValue.text = stat.baseStat.toString()
                        }
                    }
                }

            }

        })

    }

}
