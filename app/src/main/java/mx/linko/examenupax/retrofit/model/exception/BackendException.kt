package mx.linko.examenupax.retrofit.model.exception

import java.io.IOException

class BackendException constructor(private val messageCustom : String) : IOException(){
    override val message: String?
        get() = messageCustom
}