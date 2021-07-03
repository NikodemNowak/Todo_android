package com.nikodem.todo.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<STATE : ViewState>(
    private val initialState: STATE
) : ViewModel() {
    private val _viewState: MutableLiveData<STATE> = MutableLiveData(initialState)
    val viewState: LiveData<STATE> = _viewState

    val isInitialState: Boolean
        get() = _viewState.value === initialState
    val currentState: STATE
        get() = viewState.value!!


    fun updateViewState(update: (STATE) -> STATE) {
        val newState = update(_viewState.value!!)
        if (newState != _viewState.value!!) {
            _viewState.value = newState
        }
    }
}
