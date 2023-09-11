package mx.linko.examenupax.retrofit.Validation

import com.google.gson.Gson
import mx.linko.examenupax.retrofit.model.exception.BackendException
import mx.linko.examenupax.retrofit.model.inter.ValidationCode
import retrofit2.Response

class ValidationCommun<T> : ValidationCode<Response<T>> {
    val gson = Gson();
    override fun executeValidation(response: Response<T>) {
        if(response.code() != 200 && response.code()!=201){
            throw BackendException("No fue posible consultar la información, intentelo más tarde.")
        }
    }
}