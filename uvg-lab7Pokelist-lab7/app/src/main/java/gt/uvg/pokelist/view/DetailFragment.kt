package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R
import gt.uvg.pokelist.databinding.FragmentDetailBinding
import gt.uvg.pokelist.repository.PokemonRepository


class DetailFragment : Fragment() {
    companion object{
        val PokemonID = "pokemonID"
    }
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private var pokemonID: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{pokemonID = it.getInt(PokemonID)}
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemonList = PokemonRepository().getPokemonList()
        val details = pokemonList.find{it.id == pokemonID}
        binding.textView.text= "Front"
        Picasso.get().load(details!!.imageUrlFront).placeholder(R.drawable.image_not_found).error(R.drawable.image_not_found).into(binding.imageView2)
        binding.textView2.text= "Back"
        Picasso.get().load(details!!.imageUrlBack).placeholder(R.drawable.image_not_found).error(R.drawable.image_not_found).into(binding.imageView3)
        binding.textView3.text= "Front Shiny"
        Picasso.get().load(details!!.imageUrlShinnyFront).placeholder(R.drawable.image_not_found).error(R.drawable.image_not_found).into(binding.imageView4)
        binding.textView4.text= "Back Shiny"
        Picasso.get().load(details!!.imageUrlShinnyBack).placeholder(R.drawable.image_not_found).error(R.drawable.image_not_found).into(binding.imageView5)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}