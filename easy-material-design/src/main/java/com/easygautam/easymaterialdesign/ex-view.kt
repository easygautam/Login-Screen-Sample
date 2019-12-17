package com.easygautam.easymaterialdesign

import android.widget.EditText
import androidx.core.widget.doAfterTextChanged

/**
 * Listen after text change
 */
inline fun EditText.onChange(crossinline change: (value: String?) -> Unit) = run {
    doAfterTextChanged {
        change(it?.toString())
    }
}