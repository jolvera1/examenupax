package mx.linko.examenupax.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import mx.linko.examenupax.dataBase.dao.PokemonDao
import mx.linko.examenupax.dataBase.tablas.Pokemon

@Database(entities = [Pokemon::class], version = 1)
abstract class BaseDatos : RoomDatabase() {
    abstract val pokemonDao: PokemonDao

    companion object {
        const val DB_NAME = "database-name"
    }
}