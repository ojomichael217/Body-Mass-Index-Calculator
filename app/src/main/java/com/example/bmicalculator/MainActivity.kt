package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightText = findViewById<EditText>(R.id.editTextWeight)
        val heightText = findViewById<EditText>(R.id.editTextHeight)
        val calculatorButton = findViewById<Button>(R.id.buttonCalculator)

        // making the button react to the weight and height respectively by setting onClickListener
        calculatorButton.setOnClickListener {
            val weight = weightText.text.toString()
            val height = heightText.text.toString()

            val bodyMassIndex =
                weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))
            // Expecting result to come out in two decimal places using float
            val bodyMassIndex2Digits = String.format("%.2f", bodyMassIndex).toFloat()
            displayResult(bodyMassIndex2Digits)
            //calling bodyMassIndex2Digits

        }

    }

    private fun displayResult(bodyMassIndex: Float) {
        val resultIndex = findViewById<TextView>(R.id.textViewNumber)
        val info = findViewById<TextView>(R.id.textViewInformation)

        resultIndex.text = bodyMassIndex.toString()
        info.text = ""

    }
}
