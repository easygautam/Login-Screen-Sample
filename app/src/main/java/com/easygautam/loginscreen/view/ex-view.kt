package com.easygautam.loginscreen.view

import android.util.Patterns
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("errorText")
fun TextInputLayout.setErrorText(text: String?) {
    if (text.isNullOrEmpty()) {
        this.error = null
    } else {
        error = text
    }
}

/**
 * Listen after text change
 */
inline fun EditText.onChange(crossinline change: (value: String?) -> Unit) = run {
    doAfterTextChanged {
        change(it?.toString())
    }
}

fun TextInputLayout.showError(isError: Boolean, errorText: String?, helperText: String? = null) {

    if (isError) {
        if (editText?.text.toString().isEmpty()) {
            this.helperText = helperText
        } else {
            this.error = errorText
        }
    } else {
        this.error = null
        if (editText?.text.toString().isNotEmpty()) {
            this.helperText = null
        }
    }

}

fun String?.isNotEmailValid(): Boolean {
    this?.let { it ->
        return !Patterns.EMAIL_ADDRESS.matcher(it).matches()
    } ?: return false
}

