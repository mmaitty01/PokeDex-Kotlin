package org.swu.pokedex0528.userinterface.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import org.swu.pokedex0528.R
import org.swu.pokedex0528.databinding.ActivitySplashScreenBinding
import org.swu.pokedex0528.viewmodel.PokeDexViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashScreenActivity : AppCompatActivity() {
    private val viewModel : PokeDexViewModel by viewModel()

    private val binding: ActivitySplashScreenBinding by lazy { ActivitySplashScreenBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initObserver()

    }

    private fun initObserver() {


        viewModel.apply {

            pokemonList.observe(this@SplashScreenActivity, Observer {

                startActivity(
                    Intent(this@SplashScreenActivity,MainActivity::class.java)
                )

                finish()

            })

            getPokemonList()

        }


    }

}
