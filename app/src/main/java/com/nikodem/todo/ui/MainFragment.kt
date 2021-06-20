package com.nikodem.todo.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial
import com.nikodem.todo.R

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val submitButton = view.findViewById<Button>(R.id.submit_button)
        submitButton.setOnClickListener { onSubmitButtonClick() }
    }

    private fun onSubmitButtonClick() {
        val firstName = requireView().findViewById<EditText>(R.id.first_name)
        val lastName = requireView().findViewById<EditText>(R.id.last_name)
        val username = requireView().findViewById<EditText>(R.id.username)
        val password = requireView().findViewById<EditText>(R.id.password)
        val repeatPassword = requireView().findViewById<EditText>(R.id.repeat_password)
        val isAdult = requireView().findViewById<SwitchMaterial>(R.id.adult_switch).isChecked
        var isError = false;

        if (firstName.text.isEmpty()) {
            firstName.error = getString(R.string.first_name_error)
            isError = true
        }
        if (lastName.text.isEmpty()) {
            lastName.error = "Last name cannot be empty"
            isError = true
        }
        if (username.text.isEmpty()) {
            username.error = "Username cannot be empty"
            isError = true
        }
        if (username.text.length < 3) {
            username.error = "Username must have minimum 3 letters"
            isError = true
        }
        if (password.text.isEmpty()) {
            password.error = "Password cannot be empty"
            isError = true
        }
        if (repeatPassword.text.isEmpty()) {
            repeatPassword.error = "Repeat password cannot be empty"
            isError = true
        }
        if (password.text.equals(repeatPassword.text)) {
            password.error = "Passwords don't match"
            repeatPassword.error = "Passwords don't match"
            isError = true
        }
        if (!isAdult) {
            isError = true
        }

        if (isError) {
            Toast.makeText(requireContext(), "Fill in required data", Toast.LENGTH_SHORT).show()
        } else {
            val mainLayout = requireView().findViewById<LinearLayout>(R.id.main_layout)
            Snackbar.make(mainLayout, "Thank you", Snackbar.LENGTH_SHORT).show()

            findNavController().navigate(MainFragmentDirections.actionMainFragmentToSecondFragment())
        }
    }
}