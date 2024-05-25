package com.example.healthcare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class login_activity : ComponentActivity() {


    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var loginbutton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loginactivity)
        username=findViewById(R.id.username)
        password=findViewById(R.id.password)
        loginbutton=findViewById(R.id.loginbutton)


        //if don't have account then register
        val login_register=findViewById<TextView>(R.id.login_registertext)
        login_register.setOnClickListener{
            val intent= Intent(this,Register::class.java)
            startActivity(intent)
        }



        loginbutton.setOnClickListener {



            val usernameText = username.text.trim().toString()
            val passwordText = password.text.trim().toString()

            if (usernameText.isNotEmpty() && passwordText.isNotEmpty()) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

                // Navigate to appointment activity after successful login (replace with actual logic)
                val intent = Intent(this, Appointmentactivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

}

