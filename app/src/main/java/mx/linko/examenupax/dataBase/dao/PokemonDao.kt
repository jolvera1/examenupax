package mx.linko.examenupax.dataBase.dao

import androidx.room.*
import mx.linko.examenupax.dataBase.tablas.Pokemon


@Dao
interface PokemonDao {


    @Query("SELECT * FROM Pokemon ORDER BY id LIMIT :max")
    fun getPokemons(max: Int): List<Pokemon>

    @Query("SELECT * FROM Pokemon WHERE id LIKE :id")
    fun getPokemonId(id: Int): Pokemon?
    @Query("SELECT * FROM Pokemon WHERE name LIKE :name")
    fun getPokemonName(name: String): Pokemon?
    @Insert
    fun addPokemon(Pokemon: Pokemon)

    @Delete
    fun deletePokemon(Pokemon: Pokemon)

    @Update
    fun updatePokemon(Pokemon: Pokemon)
}