package com.nikodem.todo.ui.second

import androidx.lifecycle.viewModelScope
import com.nikodem.todo.repositories.CatRepository
import com.nikodem.todo.utils.BaseViewModel
import com.nikodem.todo.utils.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SecondFragmentViewModel(
    private val catRepository: CatRepository
) : BaseViewModel<SecondFragmentViewState>(
    initialState = SecondFragmentViewState()
) {
    fun loadCat() {
        updateViewState {
            it.copy(
                isLoading = true
            )
        }
        viewModelScope.launch {
            val cat = withContext(Dispatchers.IO) {
                catRepository.getRandomCat()
            }
            updateViewState {
                it.copy(
                    catUrl = cat.url,
                    id = cat.id,
                    width = cat.width.toString(),
                    height = cat.height.toString(),
                    isLoading = false
                )
            }
        }
    }
}

data class SecondFragmentViewState(
    val catUrl: String = "",
    val x: Int = 0,
    val id: String = "",
    val width: String = "",
    val height: String = "",
    override
    val isLoading: Boolean = false
) : ViewState
