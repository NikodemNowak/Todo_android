package com.nikodem.todo.ui.jokes

import android.os.Bundle
import android.view.View
import com.nikodem.todo.R
import com.nikodem.todo.databinding.FragmentJokesBinding
import com.nikodem.todo.utils.BaseFragment

class JokesFragment :
    BaseFragment<JokesFragmentViewState, JokesFragmentViewModel, FragmentJokesBinding>(
        R.layout.fragment_jokes,
        JokesFragmentViewModel::class
    ) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadJoke()

        binding.loadNewJoke.setOnClickListener {
            viewModel.loadJoke()
        }
    }
}