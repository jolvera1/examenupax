package mx.linko.examenupax.model

data class DetailModel(
    val id: Int,
    val forms: List<ListModel>,
    val sprites:typeSprite,
    val height:String,
    val weight:String,
    val types: List<TypesModel>
)