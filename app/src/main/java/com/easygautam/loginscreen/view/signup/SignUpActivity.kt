package com.easygautam.loginscreen.view.signup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.easygautam.loginscreen.R
import com.easygautam.loginscreen.databinding.ActivitySignUpBinding
import com.easygautam.loginscreen.view.isEmailNotValid
import com.easygautam.loginscreen.view.isMobileNotValid
import com.easygautam.loginscreen.view.isPasswordNotValid

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: SignUpActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModel = ViewModelProviders.of(this).get(SignUpActivityViewModel::class.java)
        // Bind view model with layout
        binding.viewModel = viewModel

        setupUiClick()
        setupInputFiled()


    }


    /**
     * Handle all buttons clicks and perform related functionality
     */
    private fun setupUiClick() {
        binding.apply {
            signUpActivityBtnSignUp.setOnClickListener {
                if (validateForm()) {
                    Toast.makeText(this@SignUpActivity, "Form validated", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setupInputFiled() {


    }

    private fun validateForm(): Boolean {
        binding.apply {
            when {
                viewModel?.firstName?.get().isNullOrEmpty() -> {
                    signUpActivityEtlFirstName.error =
                        getString(R.string.sign_up_enter_your_first_name_error)
                    return false
                }
                viewModel?.email?.get().isEmailNotValid() -> {
                    signUpActivityEtlEmail.error = getString(R.string.email_input_error)
                    return false
                }
                viewModel?.mobile?.get().isMobileNotValid() -> {
                    signUpActivityEtlMobile.error = getString(R.string.mobile_input_error)
                    return false
                }
                viewModel?.password?.get().isPasswordNotValid() -> {
                    signUpActivityEtlPassword.error = getString(R.string.password_input_error)
                    return false
                }
                viewModel?.passwordReEnter?.get() != viewModel?.password?.get() -> {
                    signUpActivityEtlPasswordReEnter.error = getString(R.string.password_re_enter_input_error)
                    return false
                }
            }
        }
        return true
    }

}
