package com.example.healthcare

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class Register : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val alreadyaccount: TextView = findViewById(R.id.alreadyaccount)
        val registerbutton: Button = findViewById(R.id.registerbutton)

        alreadyaccount.setOnClickListener {
            val intent = Intent(this, login_activity::class.java)
            startActivity(intent)
            finish() // Only finish here since we're navigating to a different screen
        }

        registerbutton.setOnClickListener {
            val newusername = findViewById<EditText>(R.id.etnewusername).text.toString()
            val newemail = findViewById<EditText>(R.id.etnewemail).text.toString()
            val newpassword = findViewById<EditText>(R.id.etnewpassword).text.toString()
            val newconfirmpassword =
                findViewById<EditText>(R.id.etnewconfirmpassword).text.toString()

            Log.d("RegisterActivity", "Register button clicked")

            if (isValidRegistration(newusername, newemail, newpassword, newconfirmpassword)) {
                Log.d("RegisterActivity", "Registration successful, starting Appointmentactivity")
                val intent = Intent(this, Appointmentactivity::class.java)
                startActivity(intent)
            } else {
                Log.d("RegisterActivity", "Registration Failed")
                Toast.makeText(this, "Registration failed! Please fix errors.",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidRegistration(
        username: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields",Toast.LENGTH_SHORT).show()
            return false
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "Passwords do not match!",Toast.LENGTH_SHORT).show()
            return false
        }

        // You can add additional validation logic here (e.g., email format)
        return true
    }
}
