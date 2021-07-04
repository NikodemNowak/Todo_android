package com.nikodem.todo.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.nikodem.todo.R
import com.nikodem.todo.databinding.FragmentMainBinding
import com.nikodem.todo.utils.BaseFragment

class MainFragment : BaseFragment<MainFragmentViewState, MainFragmentViewModel, FragmentMainBinding>(
    R.layout.fragment_main,
    MainFragmentViewModel::class
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            firstName.doOnTextChanged { text, _, _, _ ->
                viewModel.updateFirstName(text.toString())
            }
            lastName.doOnTextChanged { text, _, _, _ ->
                viewModel.updateLastName(text.toString())
            }
            username.doOnTextChanged { text, _, _, _ ->
                viewModel.updateUsername(text.toString())
            }
            password.doOnTextChanged { text, _, _, _ ->
                viewModel.updatePassword(text.toString())
            }
            repeatPassword.doOnTextChanged { text, _, _, _ ->
                viewModel.updateRepeatPassword(text.toString())
            }
            adultSwitch.setOnCheckedChangeListener { _, isChecked ->
                viewModel.updateIsAdult(isChecked)
            }

            submitButton.setOnClickListener { viewModel.onSubmitButtonClick() }
        }

        viewModel.navigateToSecondFragmentEvent.observe(viewLifecycleOwner) {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToSecondFragment())
        }
    }
}