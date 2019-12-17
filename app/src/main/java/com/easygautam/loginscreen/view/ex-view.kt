package com.easygautam.loginscreen.view

import androidx.databinding.BindingAdapter
import com.easygautam.easymaterialdesign.setEnableSmooth
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("enableLiveHelper")
fun TextInputLayout.setEnableLiveHelper(enable: Boolean) {
    setEnableSmooth(enable)
}



