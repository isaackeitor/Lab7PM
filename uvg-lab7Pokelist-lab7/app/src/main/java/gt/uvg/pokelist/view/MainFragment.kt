package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import gt.uvg.pokelist.repository.PokemonRepository

class MainFragment: Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemonList = PokemonRepository().getPokemonList()
    }
}