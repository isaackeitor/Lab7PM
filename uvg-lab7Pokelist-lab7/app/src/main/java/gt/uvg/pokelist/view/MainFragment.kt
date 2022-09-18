package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.databinding.FragmentMainBinding
import gt.uvg.pokelist.repository.PokemonRepository


class MainFragment: Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pokemonList = PokemonRepository().getPokemonList()
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        //recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = PokemonListAdapter(pokemonList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}