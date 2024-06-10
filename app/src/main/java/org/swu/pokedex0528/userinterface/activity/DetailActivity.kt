package org.swu.pokedex0528.userinterface.activity


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.google.android.material.tabs.TabLayoutMediator
import org.swu.pokedex0528.R
import org.swu.pokedex0528.databinding.ActivityDetailBinding
import org.swu.pokedex0528.model.SimplePokemon
import org.swu.pokedex0528.userinterface.adapter.PokemonDetailPagerAdapter
import org.swu.pokedex0528.userinterface.fragment.DetailFragment
import org.swu.pokedex0528.userinterface.fragment.MoveFragment
import org.swu.pokedex0528.viewmodel.PokeDexViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailActivity : AppCompatActivity() {

    companion object{

        private val KEY_SIMPLE_POKEMON = "KEY_SIMPLE_POKEMON"

        fun launch(context: Context, simplePokemon: SimplePokemon){
            val intent = Intent(context,DetailActivity::class.java).apply {
                putExtra(KEY_SIMPLE_POKEMON,simplePokemon)
            }
            context.startActivity(intent)
        }

    }

    private val binding: ActivityDetailBinding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    private val viewModel : PokeDexViewModel by viewModel()

    private val pagerAdapter = PokemonDetailPagerAdapter(supportFragmentManager,lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        initObserver()

        intent.extras?.getParcelable<SimplePokemon>(KEY_SIMPLE_POKEMON)?.let {
            viewModel.getPokemonDetail(it.name)
        }

    }

    private fun initView() {

        with(binding){

            ivBackButton.setOnClickListener {
                finish()
            }

            viewPager.adapter = pagerAdapter
            TabLayoutMediator(tabLayout,viewPager){ tab, position ->
                tab.text = when(position){
                    0-> "Details"
                    1-> "Move & Ability"
                    else -> ""
                }
            }.attach()

            // todo wait for add fragment
            pagerAdapter.setFragment(
                listOf(
                    DetailFragment(),
                    MoveFragment()
                )
            )

        }

    }


    private fun initObserver() {

        with(viewModel){

            pokemonDetail.observe(this@DetailActivity, Observer {

                binding.data = it
                binding.executePendingBindings()

            })


        }

    }

}


