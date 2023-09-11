package mx.linko.examenupax.dataBase.tablas

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Pokemon")

data class Pokemon(
    @PrimaryKey
    var id: Int,
    val img: String,
    val height: Int,
    val weight: Int,
    val type1: String,
    val type2: String,
    val fav: Int,

    )