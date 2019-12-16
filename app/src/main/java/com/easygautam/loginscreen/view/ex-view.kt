package com.easygautam.loginscreen.view

import android.util.Patterns
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("enableLiveHelper")
fun TextInputLayout.setEnableLiveHelper(enable: Boolean) {
    val mHelperText = this.helperText
    if (enable) {
        editText?.onChange {
            // Disable error
            if (isErrorEnabled) isErrorEnabled = false
            // Show helper text if input is empty
            if (it == null || it.isEmpty()) {
                this.helperText = mHelperText
                this.isHelperTextEnabled = true
            }
            // Disable helper if starting input
            else {
                this.isHelperTextEnabled = false
            }
        }
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



fun String?.isEmailNotValid(): Boolean {
    this?.let { it ->
        return !Patterns.EMAIL_ADDRESS.matcher(it).matches()
    } ?: return true
}

fun String?.isPasswordNotValid(): Boolean {
    this?.length?.let { it ->
        return it < 5
    } ?: return true
}

fun String?.isMobileNotValid(): Boolean {
    this?.length?.let { it ->
        return it < 10
    } ?: return true
}

