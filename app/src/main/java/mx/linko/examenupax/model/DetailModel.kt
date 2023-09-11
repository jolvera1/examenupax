package mx.linko.examenupax.model

data class DetailModel(
    val id: Int,
    val forms: List<ListModel>,
    val sprites:typeSprite,
    val height:Int,
    val weight:Int,
    val types: List<TypesModel>
)