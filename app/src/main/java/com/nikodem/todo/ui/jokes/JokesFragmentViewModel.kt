package com.nikodem.todo.ui.jokes

import androidx.lifecycle.viewModelScope
import com.nikodem.todo.repositories.JokesRepository
import com.nikodem.todo.utils.BaseViewModel
import com.nikodem.todo.utils.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class JokesFragmentViewModel(
    private val jokesRepository: JokesRepository
) : BaseViewModel<JokesFragmentViewState>(
    initialState = JokesFragmentViewState()
) {
    fun loadJoke() {
        updateViewState {
            it.copy(
                isLoading = true
            )
        }
        viewModelScope.launch {
            val joke = withContext(Dispatchers.IO) {
                jokesRepository.getRandomJoke()
            }
            Timber.d("ERROR!!!")
            Timber.d(joke.toString())
            updateViewState {
                it.copy(
                    joke = joke.value.joke,
                    jokeId = joke.value.id.toString(),
                    isLoading = false
                )
            }
        }
    }
}

data class JokesFragmentViewState(
    val joke: String = "",
    val jokeId: String = "",
    override val isLoading: Boolean = false
) : ViewState