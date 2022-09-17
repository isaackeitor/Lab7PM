package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.databinding.FragmentMainBinding


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
        recyclerView = binding.recyclerView
        // Sets the LayoutManager of the recyclerview
        // On the first run of the app, it will be LinearLayoutManager
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = PokemonListAdapter()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}