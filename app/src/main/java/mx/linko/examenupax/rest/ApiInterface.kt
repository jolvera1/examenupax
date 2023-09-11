package mx.linko.examenupax.rest

import kotlinx.coroutines.Deferred
import mx.linko.examenupax.config.WebConfig
import mx.linko.examenupax.model.DetailModel
import mx.linko.examenupax.model.ListResponModel
import retrofit2.Response
import retrofit2.http.*


interface ApiInterface {
    @GET(WebConfig.POKEMON)
    fun getPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Deferred<Response<ListResponModel>>

    @GET(WebConfig.POKEMON)
    fun getPokemon(@Query("limit") limit: Int): Deferred<Response<ListResponModel>>

    @GET(WebConfig.POKEMONDETAIL)
    fun getDetailPokemon(
        @Path("name") name: String
    ): Deferred<Response<DetailModel>>

}
