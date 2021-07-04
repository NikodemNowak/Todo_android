package com.nikodem.todo.ui.ssecond

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.nikodem.todo.R
import com.nikodem.todo.databinding.FragmentSecondBinding
import com.nikodem.todo.utils.BaseFragment
import com.squareup.picasso.Picasso

class SecondFragment :
    BaseFragment<SecondFragmentViewState, SecondFragmentViewModel, FragmentSecondBinding>(
        R.layout.fragment_second,
        SecondFragmentViewModel::class
    ) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadCat()

        binding.loadNewCatButton.setOnClickListener {
            viewModel.loadCat()
        }
    }

    override fun onStateChanged(state: SecondFragmentViewState) {
        if (state.catUrl.isNotEmpty()) {
            val catImageView = requireView().findViewById<ImageView>(R.id.cat_image_view)
            Picasso.get().load(state.catUrl).into(catImageView);
        }
    }
}