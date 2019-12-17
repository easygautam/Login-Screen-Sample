package com.easygautam.easymaterialdesign

import com.google.android.material.textfield.TextInputLayout


fun TextInputLayout.setEnableSmooth(enable: Boolean) {
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
