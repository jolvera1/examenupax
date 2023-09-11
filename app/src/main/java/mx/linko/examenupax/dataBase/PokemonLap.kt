package mx.linko.examenupax.dataBase

import android.content.Context
import androidx.room.Room
import mx.linko.examenupax.dataBase.dao.PokemonDao
import mx.linko.examenupax.dataBase.tablas.Pokemon

class PokemonLap(context: Context) {
    private val pokemonDao: PokemonDao

    init {
        val appContext = context.applicationContext
        val database = Room.databaseBuilder<baseDatos>(
            appContext,
            baseDatos::class.java, "pokemon"
        )
            .fallbackToDestructiveMigration().build()
        pokemonDao = database.pokemonDAO
    }

    val pokemonNombre: List<Pokemon>
        get() = pokemonDao.getPokemon




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