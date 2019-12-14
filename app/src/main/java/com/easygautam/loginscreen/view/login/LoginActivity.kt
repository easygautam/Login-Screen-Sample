package com.easygautam.loginscreen.view.login

import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.easygautam.loginscreen.R
import com.easygautam.loginscreen.view.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(LoginActivityViewModel::class.java)


        setupUiClick()
        setupLoginInputFiled()

        if (viewModel.isCreatePasswordActive) {
            setupCreatePasswordInputField()
            showCreatePasswordForm(false)
        }
    }


    /**
     * Handle all buttons clicks and perform related functionality
     */
    private fun setupUiClick() {

        loginActivity_btnLogin.setOnClickListener {
            viewModel.isCreatePasswordActive = true
            setupCreatePasswordInputField()
            showCreatePasswordForm(true)
        }

        loginActivity_btnGmail.setOnClickListener {

        }

        loginActivity_btnFacebook.setOnClickListener {

        }

        loginActivity_btnForgotPassword.setOnClickListener {

        }

    }

    private fun setupLoginInputFiled() {

        /**
         * Set email into edit text and validate email on change
         */
        loginActivity_etEmail.apply {
            onChange {
                loginActivity_etlEmail.showError(
                    isError = it.isNotEmailValid(),
                    errorText = getString(R.string.login_email_input_error),
                    helperText = getString(R.string.login_email_input_hint)
                )
                viewModel.email = it
            }
            setText(viewModel.email)
        }


        /**
         * Set password into edit text validate email on change
         */
        loginActivity_etPassword.apply {
            onChange {
                loginActivity_etlPassword.showError(
                    // Password should be greater than 5
                    isError = (it.isNullOrEmpty() || it.length < 6),
                    errorText = getString(R.string.login_password_input_error),
                    helperText = getString(R.string.login_password_input_hint)
                )
                viewModel.password = it
            }
            setText(viewModel.password)
        }

    }

    /**
     * Create password
     */
    private fun setupCreatePasswordInputField() {

        /**
         * Set password into edit text validate email on change
         */
        loginActivity_etCreatePassword.apply {
            onChange {
                viewModel.createPassword = it
                loginActivity_etlCreatePassword.showError(
                    // Password should be greater than 5
                    isError = (it.isNullOrEmpty() || it.length < 6),
                    errorText = getString(R.string.login_password_input_error),
                    helperText = getString(R.string.login_password_input_hint)
                )
            }
            setText(viewModel.createPassword)
        }

        /**
         * Set password into edit text validate email on change
         */
        loginActivity_etCreatePasswordReEnter.apply {
            onChange {
                viewModel.createRetypePassword = it
                loginActivity_etlCreatePasswordReEnter.showError(
                    // Password should be greater than 5
                    isError = (it.isNullOrEmpty() || it.length < 6 || viewModel.createPassword != viewModel.createRetypePassword),
                    errorText = getString(R.string.login_password_re_enter_input_error),
                    helperText = getString(R.string.login_password_re_enter_input_hint)
                )
            }
            setText(viewModel.createRetypePassword)
        }
    }

    private fun showCreatePasswordForm(animate: Boolean) {
        loginActivity_llLoginContainer.apply {
            visibility = INVISIBLE
            if (animate)
                startAnimation(outToLeftAnimation())
        }

        loginActivity_llCreatePasswordContainer.apply {
            visibility = VISIBLE
            if (animate)
                startAnimation(inFromRightAnimation())
        }
    }

}
