package com.isa.basicunitconverter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivityDataRate : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_data_rate)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        val adapter = ArrayAdapter.createFromResource(this, R.array.datarate, R.layout.spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val from = findViewById<View>(R.id.spinner_from) as Spinner
        val to = findViewById<View>(R.id.spinner_to) as Spinner

        from.adapter = adapter
        to.adapter = adapter

    }

    fun goBackMainMenu(view: View?) {
        val btn = findViewById<View>(R.id.back) as Button

        btn.setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivityDataRate,
                    MainMenuActivity::class.java
                )
            )
        }
    }

    fun convertDataRate(view: View?) {
        val check = findViewById<View>(R.id.button_convert) as Button
        check.setOnClickListener {
            val toEditText = findViewById<View>(R.id.editText_to) as EditText
            val fromEditText = findViewById<View>(R.id.editText_from) as EditText


            val fromSpinner = findViewById<View>(R.id.spinner_from) as Spinner
            val toSpinner = findViewById<View>(R.id.spinner_to) as Spinner
            val fromString = fromSpinner.selectedItem as String
            val toString = toSpinner.selectedItem as String

            val fromUnit: ConverterDataTransferRate.UnitsDataRateTransfer = ConverterDataTransferRate.UnitsDataRateTransfer.fromString(fromString)
            val toUnit: ConverterDataTransferRate.UnitsDataRateTransfer = ConverterDataTransferRate.UnitsDataRateTransfer.fromString(toString)

            val converter = ConverterDataTransferRate(fromUnit, toUnit)


            val str = fromEditText.text.toString().trim { it <= ' ' }
            var valid = true
            var `val` = 0.0

            try {
                `val` = str.toDouble()
            } catch (e: NumberFormatException) {
                valid = false
            }
            if (valid) {
                // use the number
                if (fromEditText.text.toString().trim { it <= ' ' }.length > 0) {
                    val input = fromEditText.text.toString().trim { it <= ' ' }.toDouble()
                    val result = converter.convertDataRate(input)
                    toEditText.setText(result.toString())
                }
            } else {
                // handle invalid entry
                Toast.makeText(this@MainActivityDataRate, "Input is invalid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}