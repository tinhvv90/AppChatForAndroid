package com.simson.appChat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register_button_register.setOnClickListener {
            performRegister()
        }

        already_have_account_text_view.setOnClickListener {
            Log.d("MainActivity", "try to show login activity")

            // launch the login activity somehow
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun performRegister() {
        val email = email_edittext_register.text.toString()
        val password = password_edittext_register.text.toString()

        Log.d("MainActivity", "Email is: " + email)
        Log.d("MainActivity", "Password: $password")

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter text in email/pw",
                Toast.LENGTH_SHORT).show()
            return
        }

        // Firebase Authentication to create a user with email and password
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (!it.isSuccessful) return@addOnCompleteListener

                // Sign in success, update UI with the signed-in user's information
                Log.d("MainActivity", "Successfully created user with uid: ")

            }
            .addOnFailureListener{
                Log.d("Main", "Failed to create user : ${it.message}")
                Toast.makeText(this, "Failed to create user : ${it.message}",
                    Toast.LENGTH_SHORT).show()
            }
    }
}
