package com.example.lab5

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var okButton: Button
    private lateinit var firstFormatButton: RadioButton
    private lateinit var secondFormatButton: RadioButton
    private lateinit var thirdFormatButton: RadioButton
    val editV: TextView = findViewById(R.id.editTextNumber)
    var countValue: Int = editV.text.toString().toIntOrNull() ?:0

    var costValue: Int = 0
    val firstCost: Int = 100
    val secondCost: Int = 150
    val thirdCost: Int = 300


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        okButton = findViewById(R.id.button)
        firstFormatButton = findViewById(R.id.radioButton)
        secondFormatButton = findViewById(R.id.radioButton2)
        thirdFormatButton = findViewById(R.id.radioButton3)



    }
}