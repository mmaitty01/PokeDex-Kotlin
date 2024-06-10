package org.swu.pokedex0528.userinterface.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import org.swu.pokedex0528.R

import org.koin.androidx.viewmodel.ext.android.viewModel
import org.swu.pokedex0528.databinding.ActivityMainBinding
import org.swu.pokedex0528.userinterface.adapter.PokemonListAdapter
import org.swu.pokedex0528.viewmodel.PokeDexViewModel


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModel: PokeDexViewModel by viewModel()
    private val adapter = PokemonListAdapter(mutableListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        initObserver()
        viewModel.getPokemonList()
    }


    private fun initView() {

        adapter.setOnClickListener {

            // todo open detail page
        }

        with(binding){

            recyclerView.adapter = adapter
            ivClearSearch.setOnClickListener {

                etSearch.setText("")

            }

            etSearch.doOnTextChanged { text, start, before, count ->

                ivClearSearch.isVisible = !text.isNullOrEmpty()

                adapter.filter.filter(text)

            }

        }


    }

    private fun initObserver() {

        viewModel.apply {

            pokemonList.observe(this@MainActivity, Observer {


            })


            errorData.observe(this@MainActivity, Observer {

                AlertDialog.Builder(this@MainActivity).create().apply {
                    setMessage(it)
                    setButton(AlertDialog.BUTTON_NEUTRAL, "OK") { dialog, which ->
                        dialog.dismiss()
                    }
                }.show()

            })
        }
    }
}