package com.nikodem.todo.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.nikodem.todo.R
import com.nikodem.todo.repositories.CatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

class SecondFragment : Fragment(R.layout.fragment_second) {
    val catRepository: CatRepository by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val cat = withContext(Dispatchers.IO) {
                catRepository.getRandomCat()
            }
            print("d")
        }
    }
}