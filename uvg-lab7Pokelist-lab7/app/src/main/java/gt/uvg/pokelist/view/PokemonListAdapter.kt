package gt.uvg.pokelist.view
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.databinding.ItemPokemonViewBinding
import gt.uvg.pokelist.model.Pokemon

class PokemonListAdapter(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonListAdapter.PokemonListHolder>() {

    inner class PokemonListHolder(val binding: ItemPokemonViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListHolder {
        val binding = ItemPokemonViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListHolder(binding)
    }


    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) {
        val character = pokemonList.get(position)
        holder.binding.pokemonName.text = character.name
        Picasso.get().load(character.imageUrlFront).into(holder.binding.pokemonPhoto)

        holder.binding.root.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(character.id)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}