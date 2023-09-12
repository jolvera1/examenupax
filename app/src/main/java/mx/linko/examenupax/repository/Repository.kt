package mx.linko.examenupax.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import mx.linko.examenupax.config.WebConfig
import mx.linko.examenupax.dataBase.PokemonLap
import mx.linko.examenupax.dataBase.tablas.Pokemon
import mx.linko.examenupax.rest.ApiInterface
import mx.linko.examenupax.retrofit.Validation.ValidationCommun
import mx.linko.examenupax.retrofit.build.RetrofitApp
import mx.linko.examenupax.retrofit.managercall.ManagerCall


class Repository(val context: Context) : ManagerCall() {
    //val profileResponse
    val offsetResponse = MutableLiveData<Int>()


    val errorResponse = MutableLiveData<String>()
    var max = 0
    var iteracion = 0
    var act = 0

    private val retrofitInstance = RetrofitApp.Build<ApiInterface>()
        .setContext(context)
        .setEnvironment(true)
        .setClass(ApiInterface::class.java)

    suspend fun getAllPokemon(limit: Int) {
        managerCallApi(
            call = {
                retrofitInstance
                    .setHost(WebConfig.HOST)
                    .builder().instance().getPokemon(limit).await()
            },
            validation = ValidationCommun(),
            context = context
        ).let { response ->
            GlobalScope.launch(Dispatchers.Main) {
                if (response.sucess) {
                    response.data?.let { d ->
                        if (!d.results.isNullOrEmpty()) {
                            max = d.results.size
                            iteracion = 0
                            d.results.forEach { item ->
                                getDetailPokemon(item.name)
                            }
                        }
                    }
                } else {
                    errorResponse.value = response.exception!!.message
                }
            }
        }
    }

    suspend fun getAllPokemon(limit: Int, offset: Int) {
        managerCallApi(
            call = {
                retrofitInstance
                    .setHost(WebConfig.HOST)
                    .builder().instance().getPokemon(limit, offset).await()
            },
            validation = ValidationCommun(),
            context = context
        ).let { response ->
            GlobalScope.launch(Dispatchers.Main) {
                if (response.sucess) {
                    response.data?.let { d ->
                        if (!d.results.isNullOrEmpty()) {
                            max = d.results.size
                            iteracion = 0
                            act = offset
                            d.results.forEach { item ->
                                val pokemonLap = PokemonLap(context)
                                if (pokemonLap.pokemonNombre(item.name) == null) {
                                    getDetailPokemon(item.name)
                                }
                            }
                        }
                    }
                } else {
                    errorResponse.value = response.exception!!.message
                }
            }
        }
    }

    suspend fun getDetailPokemon(name: String) {

        managerCallApi(
            call = {
                retrofitInstance
                    .setHost(WebConfig.HOST)
                    .builder().instance().getDetailPokemon(name).await()
            },
            validation = ValidationCommun(),
            context = context
        ).let { response ->
            GlobalScope.launch(Dispatchers.Main) {
                if (response.sucess) {
                    response.data?.let { d ->
                        var type2 = ""
                        val type1 = d.types[0].type.name
                        if (d.types.size > 1) {
                            type2 = d.types[1].type.name
                        }
                        val pokemon = Pokemon(
                            d.id,
                            d.forms[0].name,
                            d.sprites.front_default,
                            d.height,
                            d.weight,
                            type1,
                            type2,
                            0
                        )
                        addPokemon(pokemon)
                        iteracion++
                        if (max == iteracion) {
                            offsetResponse.value = max + act
                        }

                    }
                } else {
                    errorResponse.value = response.exception!!.message
                }
            }
        }
    }

    fun addPokemon(p: Pokemon) {
        GlobalScope.launch {

            val pokemonLap = PokemonLap(context)
            if (pokemonLap.pokemonId(p.id) == null) {
                pokemonLap.addPokemon(p)
            }

        }
    }

}