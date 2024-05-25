package com.example.healthcare

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity

class SplashScreen : ComponentActivity() {
    private val SPLASH_TIME_OUT: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreenhealthcare)

        Handler().postDelayed({
            startActivity(Intent(this, login_activity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}