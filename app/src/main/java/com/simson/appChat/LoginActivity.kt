package com.simson.appChat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener {
            val email = email_edittext_login.text.toString()
            val password = password_edittext_login.text.toString()

            Log.d("LoginActivity", "attempt login with email/pw: $email/ $password")
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
        }

        back_to_register_textview.setOnClickListener {
            finish()
        }
    }
}
