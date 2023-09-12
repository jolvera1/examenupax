package mx.linko.examenupax.dataBase

import android.content.Context
import androidx.room.Room
import mx.linko.examenupax.dataBase.dao.PokemonDao
import mx.linko.examenupax.dataBase.tablas.Pokemon

class PokemonLap(context: Context) {
    private val pokemonDao: PokemonDao

    init {
        val appContext = context.applicationContext
        val database = Room.databaseBuilder<BaseDatos>(
            appContext,
            BaseDatos::class.java, "Pokemon"
        ).build()
        pokemonDao = database.pokemonDao
    }

    fun pokemons(max: Int):  List<Pokemon> {
        return pokemonDao.getPokemons(max)
    }

    fun pokemonId(id: Int):  Pokemon? {
        return pokemonDao.getPokemonId(id)
    }
    fun pokemonNombre(name: String):   Pokemon?{
        return pokemonDao.getPokemonName(name)
    }

    fun addPokemon(pokemon: Pokemon) {
        pokemonDao.addPokemon(pokemon)
    }

    fun updateNota(pokemon: Pokemon) {
        pokemonDao.updatePokemon(pokemon)
    }

    fun deleteNota(pokemon: Pokemon) {
        pokemonDao.deletePokemon(pokemon)
    }

    companion object {
        private var pokemonLap: PokemonLap? = null
        operator fun get(context: Context): PokemonLap? {
            if (pokemonLap == null) {
                pokemonLap = PokemonLap(context)
            }
            return pokemonLap
        }
    }
}