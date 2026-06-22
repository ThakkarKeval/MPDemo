package com.example.mpdemo.ui.cat_fact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mpdemo.repository.CatFactRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class CatFactScreenVM(private val repository: CatFactRepository) : ViewModel() {

    sealed interface Effect {
        data class ShowError(val message: String) : Effect
    }

    private val _state = MutableStateFlow(CatFactScreenStates())
    private val _effect = MutableSharedFlow<Effect>()

    val state get() = _state
    val effect = _effect.asSharedFlow()

    init {
        handleIntent(CatFactScreenIntents.LoadFact)
    }

    fun handleIntent(intent: CatFactScreenIntents) {
        when (intent) {
            is CatFactScreenIntents.LoadFact,
            is CatFactScreenIntents.ClkRefresh -> loadFact()
        }
    }

    private fun loadFact() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val fact = repository.getCatFact()
                _state.value = _state.value.copy(catFact = fact, isLoading = false)
            } catch (e: Exception) {
                _state.value = _state.value.copy(isLoading = false)
                _effect.emit(Effect.ShowError(e.message ?: "Something went wrong"))
            }
        }
    }
}
