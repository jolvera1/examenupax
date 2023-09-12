package mx.linko.examenupax.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mx.linko.examenupax.dataBase.PokemonLap
import mx.linko.examenupax.dataBase.tablas.Pokemon
import mx.linko.examenupax.repository.Repository

class ViewModel(private val repository: Repository) : ViewModel(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main
    val offset = repository.offsetResponse
    val list = MutableLiveData<List<Pokemon>>()
    var error = repository.errorResponse
    fun getAllPokemon(limit: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.getAllPokemon(limit)
            }
        }
    }

    fun getAllPokemon(limit: Int, offset: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.getAllPokemon(limit, offset)
            }
        }
    }

    fun getBase(max: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val lap = PokemonLap(repository.context)
                val l = lap.pokemons(max)

                list.postValue(l)


            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        cancel()
    }
}