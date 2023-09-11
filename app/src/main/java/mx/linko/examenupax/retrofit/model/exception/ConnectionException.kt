package mx.linko.examenupax.retrofit.model.exception

import java.io.IOException

class ConnectionException(private val messageCustom : String? = null) : IOException(){
    override val message: String?
        get() = messageCustom ?: "Error de conexión."
}