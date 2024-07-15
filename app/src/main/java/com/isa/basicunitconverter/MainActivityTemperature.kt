package com.isa.basicunitconverter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivityTemperature : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_temperature)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        val etCelsius = findViewById<EditText>(R.id.et_celsius)
        val etFahrenheit = findViewById<EditText>(R.id.et_fahrenheit)
        val etKelvin = findViewById<EditText>(R.id.et_kelvin)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)
        val btnReset = findViewById<Button>(R.id.btn_reset)

        btnCalculate.setOnClickListener {
            val celsiusText = etCelsius.text.toString()
            val fahrenheitText = etFahrenheit.text.toString()
            val kelvinText = etKelvin.text.toString()

            if (celsiusText.isNotEmpty()) {
                val celsius = celsiusText.toDouble()
                etFahrenheit.setText((celsius * 9 / 5 + 32).toString())
                etKelvin.setText((celsius + 273.15).toString())

                etCelsius.isEnabled = false
                etKelvin.isEnabled = false
                etFahrenheit.isEnabled = false

            } else if (fahrenheitText.isNotEmpty()) {
                val fahrenheit = fahrenheitText.toDouble()
                etCelsius.setText(((fahrenheit - 32) * 5 / 9).toString())
                etKelvin.setText((((fahrenheit - 32) * 5 / 9) + 273.15).toString())

                etCelsius.isEnabled = false
                etKelvin.isEnabled = false
                etFahrenheit.isEnabled = false

            } else if (kelvinText.isNotEmpty()) {
                val kelvin = kelvinText.toDouble()
                etCelsius.setText((kelvin - 273.15).toString())
                etFahrenheit.setText(((kelvin - 273.15) * 9 / 5 + 32).toString())

                etCelsius.isEnabled = false
                etKelvin.isEnabled = false
                etFahrenheit.isEnabled = false
            }
        }

        btnReset.setOnClickListener {
            etCelsius.text.clear()
            etFahrenheit.text.clear()
            etKelvin.text.clear()

            etFahrenheit.isEnabled = true
            etCelsius.isEnabled = true
            etKelvin.isEnabled = true

        }
    }

    fun goBackMainMenu(view: View?) {
        val btn = findViewById<View>(R.id.back) as Button

        btn.setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivityTemperature, MainMenuActivity::class.java
                )
            )
        }
    }
}
