package com.nikodem.todo.ui.ssecond

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.nikodem.todo.R
import com.nikodem.todo.utils.BaseFragment

class SecondFragment : BaseFragment<SecondFragmentViewState, SecondFragmentViewModel>(
    R.layout.fragment_second,
    SecondFragmentViewModel::class
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadCat()

        view.findViewById<Button>(R.id.loadNewCat).setOnClickListener {
            viewModel.loadCat()
        }
    }

    override fun onStateChanged(state: SecondFragmentViewState) {
        requireView().findViewById<TextView>(R.id.catUrl).text = "URL kota: ${state.catUrl}"
        requireView().findViewById<TextView>(R.id.catId).text = "Id kota: ${state.id}"
        requireView().findViewById<TextView>(R.id.catWidth).text = "Szerokosc kota: ${state.width}"
        requireView().findViewById<TextView>(R.id.catHeight).text = "Wysokosc kota: ${state.height}"
    }
}