package com.example.lab5

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class ResultActivity : AppCompatActivity() {

    private lateinit var backButton: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonBack: Button = this.findViewById(R.id.backButton)
        val resultText: TextView = this.findViewById(R.id.textResult)

        val res = intent.extras!!.getString("RESULT")
        resultText.text = "Оплатить: $res руб."

        buttonBack.setOnClickListener() {
            val intent = Intent(this@ResultActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }

}