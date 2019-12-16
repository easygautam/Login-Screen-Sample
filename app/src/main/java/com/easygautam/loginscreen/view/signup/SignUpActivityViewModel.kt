package com.easygautam.loginscreen.view.signup

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class SignUpActivityViewModel : ViewModel() {

    var firstName = ObservableField<String>()
    var lastName = ObservableField<String>()
    var email = ObservableField<String>()
    var mobile = ObservableField<String>()
    var password = ObservableField<String>()
    var passwordReEnter = ObservableField<String>()


}