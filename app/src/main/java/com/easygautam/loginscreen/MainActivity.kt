package com.easygautam.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.easygautam.loginscreen.view.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        textView.setOnClickListener {
//
//        }

        this.startActivity(Intent(this, LoginActivity::class.java))
    }
}
