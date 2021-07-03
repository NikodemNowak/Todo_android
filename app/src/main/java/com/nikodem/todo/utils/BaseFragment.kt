package com.nikodem.todo.utils

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

abstract class BaseFragment<STATE : ViewState, VM : BaseViewModel<STATE>>(
    @LayoutRes contentLayout: Int,
    viewModelKClass: KClass<VM>
) : Fragment(contentLayout) {

    val viewModel: VM by lazy {
        getViewModel(clazz = viewModelKClass)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner) {
            onStateChanged(it)
        }
    }

    abstract fun onStateChanged(state: STATE)
}