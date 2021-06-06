package com.nikodem.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton = findViewById<Button>(R.id.submit_button)
        submitButton.setOnClickListener { onSubmitButtonClick() }
    }

    private fun onSubmitButtonClick() {
        val firstName = findViewById<EditText>(R.id.first_name)
        val lastName = findViewById<EditText>(R.id.last_name)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val repeatPassword = findViewById<EditText>(R.id.repeat_password)
        val isAdult = findViewById<SwitchMaterial>(R.id.adult_switch).isChecked
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
        if (username.text.length < 3){
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
        if (password != repeatPassword) {
            password.error = "Passwords don't match"
            repeatPassword.error = "Passwords don't match"
            isError = true
        }
        if (!isAdult){
            isError = true
        }

        if (isError) {
            Toast.makeText(this, "Fill in required data", Toast.LENGTH_SHORT).show()
        } else {
            val mainLayout = findViewById<LinearLayout>(R.id.main_layout)
            Snackbar.make(mainLayout, "Thank you", Snackbar.LENGTH_SHORT).show()
        }
    }
}