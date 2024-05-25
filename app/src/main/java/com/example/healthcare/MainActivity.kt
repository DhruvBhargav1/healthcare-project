package com.example.healthcare

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity

class  MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Start SplashScreenActivity
        val intent = Intent(this, SplashScreen::class.java)
        startActivity(intent)
        finish() // Finish MainActivity
    }
}
