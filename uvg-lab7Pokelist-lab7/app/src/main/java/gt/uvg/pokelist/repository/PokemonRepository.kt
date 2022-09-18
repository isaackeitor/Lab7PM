package gt.uvg.pokelist.repository

import gt.uvg.pokelist.model.Pokemon

class PokemonRepository {

    // Obtain pokemon list from https://pokeapi.co/
    fun getPokemonList(): List<Pokemon> {
        return listOf(
            Pokemon(1, "bulbasaur"),
            Pokemon(2, "ivysaur"),
            Pokemon(3, "venusaur"),
            Pokemon(4, "charmander"),
            Pokemon(5, "charmeleon"),
            Pokemon(6, "charizard"),
            Pokemon(7, "squirtle"),
            Pokemon(8 , "wartortle"),
            Pokemon(9, "blastoise"),
            Pokemon(10,"caterpie"),
            Pokemon( 11, "metapod"),
            Pokemon( 12, "butterfree"),
            Pokemon( 13, "weedle"),
            Pokemon( 14, "kakuna")
        )
    }
}