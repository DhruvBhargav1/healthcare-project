package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnClickMe = findViewById<Button>(R.id.mybutton)
        val tvMyTextView = findViewById<TextView>(R.id.textView)
        var timesClick=0
        btnClickMe.setOnClickListener{
            timesClick += 1
            tvMyTextView.text= timesClick.toString()
            Toast.makeText(this,  "hey i'm a toast" , Toast.LENGTH_LONG).show()
        }
    }
}