package com.example.lab5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var okButton: Button
    private lateinit var firstFormatButton: RadioButton
    private lateinit var secondFormatButton: RadioButton
    private lateinit var thirdFormatButton: RadioButton

    private var costValue: Int = 0
    private val firstCost: Int = 100
    private val secondCost: Int = 150
    private val thirdCost: Int = 300


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editV: TextView = findViewById(R.id.editTextNumber)
        var countValue: Int = editV.text.toString().toIntOrNull() ?:1
        okButton = findViewById(R.id.button)
        firstFormatButton = findViewById(R.id.radioButton)
        secondFormatButton = findViewById(R.id.radioButton2)
        thirdFormatButton = findViewById(R.id.radioButton3)
        firstFormatButton.isChecked = true

/*        if (firstFormatButton.isActivated) {
            costValue = firstCost * countValue
        } else if (secondFormatButton.isActivated) {
            costValue = secondCost * countValue
        } else if (thirdFormatButton.isActivated) {
            costValue = thirdCost * countValue
        }*/

        okButton.setOnClickListener {

            countValue = editV.text.toString().toIntOrNull() ?:1

            when {
                (firstFormatButton.isChecked) -> {
                    costValue = firstCost * countValue
                }
                (secondFormatButton.isChecked) -> {
                    costValue = secondCost * countValue
                }
                (thirdFormatButton.isChecked) -> {
                    costValue = thirdCost * countValue
                }
            }

            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            intent.putExtra("RESULT", costValue.toString())
            startActivity(intent)
        }
    }
}