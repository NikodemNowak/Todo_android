package com.nikodem.todo.ui.main

import com.hadilq.liveevent.LiveEvent
import com.nikodem.todo.R
import com.nikodem.todo.utils.BaseViewModel
import com.nikodem.todo.utils.ContentProvider
import com.nikodem.todo.utils.ViewState
import com.nikodem.todo.utils.fireEvent
import timber.log.Timber

class MainFragmentViewModel(
    private val contentProvider: ContentProvider
) : BaseViewModel<MainFragmentViewState>(
    initialState = MainFragmentViewState()
) {
    val navigateToSecondFragmentEvent = LiveEvent<Unit>()

    fun onSubmitButtonClick() {
        Timber.d(currentState.firstName)
        resetErrors()

        if (currentState.firstName.isEmpty()) {
            updateViewState {
                it.copy(
                    firstNameError = contentProvider.getString(R.string.first_name_error),
                    isError = true
                )
            }
        }
        if (currentState.lastName.isEmpty()) {
            updateViewState {
                it.copy(
                    lastNameError = contentProvider.getString(R.string.last_name_error),
                    isError = true
                )
            }
        }
        if (currentState.username.isEmpty()) {
            updateViewState {
                it.copy(
                    userNameError = contentProvider.getString(R.string.username_error_empty),
                    isError = true
                )
            }
        }
        if (currentState.username.length < 3) {
            updateViewState {
                it.copy(
                    userNameError = contentProvider.getString(R.string.username_error_length),
                    isError = true
                )
            }
        }
        if (currentState.password.isEmpty()) {
            updateViewState {
                it.copy(
                    passwordError = contentProvider.getString(R.string.password_error),
                    isError = true
                )
            }
        }
        if (currentState.repeatPassword.isEmpty()) {
            updateViewState {
                it.copy(
                    repeatPasswordError = contentProvider.getString(R.string.repeat_password_error),
                    isError = true
                )
            }
        }
        if (currentState.password != currentState.repeatPassword) {
            updateViewState {
                it.copy(
                    passwordError = contentProvider.getString(R.string.passwords_error),
                    repeatPasswordError = contentProvider.getString(R.string.passwords_error),
                    isError = true
                )
            }
        }
        if (!currentState.isAdult) {
            updateViewState {
                it.copy(
                    isError = true
                )
            }
        }

        if (currentState.isError) {
            showToastEvent.fireEvent("Fill in required data")
        } else {
            showSnackbarEvent.fireEvent("Thank you")
            navigateToSecondFragmentEvent.fireEvent()
        }
    }

    private fun resetErrors() {
        updateViewState {
            it.copy(
                firstNameError = null,
                lastNameError = null,
                userNameError = null,
                passwordError = null,
                repeatPasswordError = null,
                isError = false
            )
        }
    }

    fun updateFirstName(text: String) {
        updateViewState {
            it.copy(
                firstName = text
            )
        }
    }

    fun updateLastName(text: String) {
        updateViewState {
            it.copy(
                lastName = text
            )
        }
    }

    fun updateUsername(text: String) {
        updateViewState {
            it.copy(
                username = text
            )
        }
    }

    fun updatePassword(text: String) {
        updateViewState {
            it.copy(
                password = text
            )
        }
    }

    fun updateRepeatPassword(text: String) {
        updateViewState {
            it.copy(
                repeatPassword = text
            )
        }
    }

    fun updateIsAdult(checked: Boolean) {
        updateViewState {
            it.copy(
                isAdult = checked
            )
        }
    }
}

data class MainFragmentViewState(
    val firstName: String = "",
    val firstNameError: String? = null,
    val lastName: String = "",
    val lastNameError: String? = null,
    val username: String = "",
    val userNameError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val repeatPassword: String = "",
    val repeatPasswordError: String? = null,
    val isAdult: Boolean = false,
    val isError: Boolean = false,
    override val isLoading: Boolean = false
) : ViewState
