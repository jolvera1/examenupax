package mx.linko.examenupax.dataBase.tablas

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Pokemon")

data class Pokemon(
    @PrimaryKey
    var id: Int,
    val name: String?,
    val img: String?,
    val height: String?,
    val weight: String?,
    val type1: String?,
    val type2: String?,
    val fav: Int

    )