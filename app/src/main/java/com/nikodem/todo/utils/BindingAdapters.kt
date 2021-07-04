package com.nikodem.todo.utils

import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("error")
fun EditText.setError(errorStr: String?) {
    error = errorStr
}