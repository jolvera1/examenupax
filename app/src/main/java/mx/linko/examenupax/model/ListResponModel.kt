package mx.linko.examenupax.model

data class ListResponModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results:List<ListModel>
)