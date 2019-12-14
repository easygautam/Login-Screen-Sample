package com.easygautam.loginscreen.view.login

import androidx.lifecycle.ViewModel

class LoginActivityViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var createPassword: String? = null
    var createRetypePassword: String? = null

    var isCreatePasswordActive: Boolean = false

}