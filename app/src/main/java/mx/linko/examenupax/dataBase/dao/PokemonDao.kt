package mx.linko.examenupax.dataBase.dao

import androidx.room.*
import mx.linko.examenupax.dataBase.tablas.Pokemon


@Dao
interface PokemonDao {


    @get:Query("SELECT * FROM Pokemon ORDER BY id")
    val getPokemon: List<Pokemon>

    @Insert
    fun addPokemon(Pokemon: Pokemon)

    @Delete
    fun deletePokemon(Pokemon: Pokemon)

    @Update
    fun updatePokemon(Pokemon: Pokemon)
}