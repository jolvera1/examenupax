package mx.linko.examenupax.retrofit.model.inter

interface ValidationCode<in T> {
    fun executeValidation(response : T)
}