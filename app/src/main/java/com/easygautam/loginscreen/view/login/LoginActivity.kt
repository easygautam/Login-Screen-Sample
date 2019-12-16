package com.easygautam.loginscreen.view.login

import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.easygautam.loginscreen.R
import com.easygautam.loginscreen.view.*
import com.easygautam.loginscreen.view.signup.SignUpActivity
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

        loginActivity_btnCreateAccount.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

    }

    private fun setupLoginInputFiled() {

        /**
         * Set email into edit text and validate email on change
         */
//        loginActivity_etEmail.apply {
//            onChange {
//                loginActivity_etlEmail.setupLiveChange(
//                    errorCondition = it.isEmailNotValid(),
//                    errorText = getString(R.string.email_input_error),
//                    helperText = getString(R.string.email_input_helper_text)
//                )
//                viewModel.email = it
//            }
//            setText(viewModel.email)
//        }


        /**
         * Set password into edit text validate email on change
         */
//        loginActivity_etPassword.apply {
//            onChange {
//                loginActivity_etlPassword.setupLiveChange(
//                    // Password should be greater than 5
//                    errorCondition = (it.isNullOrEmpty() || it.length < 6),
//                    errorText = getString(R.string.password_input_error),
//                    helperText = getString(R.string.password_input_helper_text)
//                )
//                viewModel.password = it
//            }
//            setText(viewModel.password)
//        }

    }

    /**
     * Create password
     */
    private fun setupCreatePasswordInputField() {

        /**
         * Set password into edit text validate email on change
         */
//        loginActivity_etCreatePassword.apply {
//            onChange {
//                viewModel.createPassword = it
//                loginActivity_etlCreatePassword.setupLiveChange(
//                    // Password should be greater than 5
//                    errorCondition = (it.isNullOrEmpty() || it.length < 6),
//                    errorText = getString(R.string.password_input_error),
//                    helperText = getString(R.string.password_input_helper_text)
//                )
//            }
//            setText(viewModel.createPassword)
//        }

        /**
         * Set password into edit text validate email on change
         */
//        loginActivity_etCreatePasswordReEnter.apply {
//            onChange {
//                viewModel.createRetypePassword = it
//                loginActivity_etlCreatePasswordReEnter.setupLiveChange(
//                    // Password should be greater than 5
//                    errorCondition = (it.isNullOrEmpty() || it.length < 6 || viewModel.createPassword != viewModel.createRetypePassword),
//                    errorText = getString(R.string.password_re_enter_input_error),
//                    helperText = getString(R.string.password_re_enter_input_helper_text)
//                )
//            }
//            setText(viewModel.createRetypePassword)
//        }
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
