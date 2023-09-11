package mx.linko.examenupax.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import mx.linko.examenupax.repository.Repository
import kotlinx.coroutines.*

class ViewModel(private val repository: Repository) : ViewModel(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main



    var error = repository.errorResponse


    override fun onCleared() {
        super.onCleared()
        cancel()
    }
}